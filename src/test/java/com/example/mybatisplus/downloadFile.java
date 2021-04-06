package com.example.mybatisplus;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class downloadFile {

    @Test
    public void test () {

    }

    @Test
    public void test2() {
        // 定义人名数组
        final String[] names = {"Zebe", "Hebe", "Mary", "July", "David"};
        Stream<String> stream1 = Stream.of(names);
        Stream<String> stream2 = Stream.of(names);
        Stream<String> stream3 = Stream.of(names);
        // 拼接成 [x, y, z] 形式
        String result1 = stream1.collect(Collectors.joining(", ", "[", "]"));
        // 拼接成 x | y | z 形式
        String result2 = stream2.collect(Collectors.joining(" | ", "", ""));
        // 拼接成 x -> y -> z] 形式
        String result3 = stream3.collect(Collectors.joining());
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    /**
     * date -> long
     **/
    @Test
    public void test3() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String str = "20181112";
        Date date = sdf.parse(str);
        System.out.println(date);
        System.out.println(date.getTime());
        /*String dateFormate = sdf.format(str);
        System.out.println(dateFormate);*/
    }

    /**
     * long to date
     **/
    @Test
    public void test22() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Long l =2016516516L;
        //把long转换成Date
        String format = sdf.format(new Date(l));
        sdf.format(System.currentTimeMillis());
        System.out.println(format);
    }

    @Test
    public void test223() {
        String startTree = "-123-456-";
        String endTree = "-123-456-789-";
        List<String> startList = new ArrayList<String>(Arrays.asList(startTree.substring(1).split("-")));
        List<String> endList = new ArrayList<String>(Arrays.asList(endTree.substring(1).split("-")));
        System.out.println(startList);
        System.out.println(endList);
        endList.removeAll(startList);
        //String s = startList.get(startList.size() - 1);
        System.out.println("1");
        endList.add(0, startList.get(startList.size() - 1));
        System.out.println(endList);
    }

    @Test
    public void test4() {
        String str = "【班长】801王赛18703894192 7:10:08\n" +
                "2月29日计科F1602系统当日健康信息申报：\n" +
                "1、861801 8:23:38\n" +
                "14,丁婷婷，\n" +
                "201616010429，已完成\n" +
                "\n";
        Long match = 201616010601L;
        String patern;
        for (int i = 0; i < 40; i++) {
            patern = "" + match;
            System.out.println("字符串中是否包含  " + patern + " : " + str.contains(patern));
            System.out.println(patern.length());
            match++;
        }

    }

    @Test
    public void download() {
        int num = 1;
        String photoRealUrl = "https://img-cartoon-cdn.best-one.club/bookimages/1201/";//   219318/1.jpg";   //文件URL地址
        String filePath = "C:\\Users\\QWER\\Desktop\\动漫\\1203";      //保存目录
        int number = 1;
        //for (int j = 229300; j > 0; j--) {
        for (int j = 229400; j > 0; j--) {
            int timeOutNum = 0;
            for (int i = 1; i < 40; i++) {
                if (timeOutNum > 2) {
                    continue;
                }
                int chapter = 219319 - j;
                String photoUrl = photoRealUrl + j + "/" + i + ".jpg";
                String fileName = photoUrl.substring(photoUrl.lastIndexOf("/"));     //为下载的文件命名
                String photoName = "" + number;
                try {
                    // File file = saveUrlAs(photoUrl, filePath, "GET", number+"");
                    String url = photoUrl;
                    //System.out.println("fileName---->"+filePath);
                    //创建不同的文件夹目录
                    File file = new File(filePath);
                    //判断文件夹是否存在
                    if (!file.exists()) {
                        //如果文件夹不存在，则创建新的的文件夹
                        file.mkdirs();
                    }
                    FileOutputStream fileOut = null;
                    HttpURLConnection conn = null;
                    InputStream inputStream = null;
                    /*try {*/
                    // 建立链接
                    URL httpUrl = new URL(url);
                    conn = (HttpURLConnection) httpUrl.openConnection();
                    //以Post方式提交表单，默认get方式
                    //conn.setRequestMethod(method);
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    // post方式不能使用缓存
                    conn.setUseCaches(false);
                    //连接指定的资源
                    conn.connect();
                    conn.setConnectTimeout(3000);
                    //获取网络输入流
                    inputStream = conn.getInputStream();
                    BufferedInputStream bis = new BufferedInputStream(inputStream);
                    //判断文件的保存路径后面是否以/结尾
                    if (!filePath.endsWith("/")) {
                        filePath += "/";
                    }
                    //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
                    fileOut = new FileOutputStream(filePath + photoName + ".png");
                    BufferedOutputStream bos = new BufferedOutputStream(fileOut);

                    byte[] buf = new byte[4096];
                    int length = bis.read(buf);
                    //保存文件
                    while (length != -1) {
                        bos.write(buf, 0, length);
                        length = bis.read(buf);
                    }
                    bos.close();
                    bis.close();
                    conn.disconnect();

                    number++;
                    System.out.println("第" + chapter + "章" + "第" + i + "页下载成功");
                } catch (Exception e) {
                    System.out.println("下载失败     " + e);
                    timeOutNum++;
                }
            }

        }
    }

}
