package com.ltt.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ltt.demo.bean.PropertyValueBean;
import com.ltt.demo.bean.StudentBean;
import com.ltt.demo.common.common.exception.ServiceException;
import com.ltt.demo.common.common.utils.UUIDUtils;
import com.ltt.demo.entity.Student;
import com.ltt.demo.mapper.StudentMapper;
import com.ltt.demo.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuwei
 * @since 2020-01-06
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    private static final SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");

    private static final String numberFormat = "[0-9]";

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void add(StudentBean studentBean) {
        // TODO 长度判断可以使用@Length注解
        //判断学生名字长度是否符合要求
        if (studentBean.getName().length() > 20) {
            throw new ServiceException("名字不能大于20个字!");
        }
        //学生名字为空则不入库
        if (StringUtils.isEmpty(studentBean.getName())) {
            return ;
        }
        //判断日期格式是否正确yyyyMMdd
        String a1 = "[0-9]{4}[0-9]{2}[0-9]{2}";
        boolean date = Pattern.compile(a1).matcher(String.valueOf(studentBean.getBirthday())).matches();
        if(!date){
            throw new ServiceException("日期格式错误！");
        }

        //指标名称不能重复（企业和机构可以同时存在相同的指标名称）
        //TODO 上面的注释是什么意思？

        //TODO 假如studentBean.getSno()为空，岂不是oldStudent不为null,所以studentBean.getSno()为空的学生永远无法录入？
        Student oldStudent = studentMapper.selectOne(Wrappers.<Student>lambdaQuery()
                .eq(Student::getSno, studentBean.getSno())
        );


        if (ObjectUtils.isEmpty(oldStudent)) {
            Student student=new Student();
            long lastUpdateTimestamp = System.currentTimeMillis();
            student.setLastUpdateTimestamp(lastUpdateTimestamp);
            student.setCompanyId(studentBean.getCompanyId());
            student.setSex(studentBean.getSex());
            student.setName(studentBean.getName());
            student.setOrderNum(1);
            student.setBirthday(studentBean.getBirthday());
            student = student.setSno(studentBean.getSno());//TODO 没看懂这行代码
            // TODO 添加学生的学生id,在逻辑层代码生成
            String uuid = UUIDUtils.getUUID();
            student.setId(uuid);

            studentMapper.addStudent(student);

            String studentId = student.getId();
            int num=studentBean.getPropertyValueBeanList().size();//TODO 改，int num不必要，养成不浪费的习惯
            for(PropertyValueBean propertyValueBean:studentBean.getPropertyValueBeanList()){
                propertyValueBean.setStudentId(studentId);
                if( propertyValueBean.getType()==1){
                    boolean number = Pattern.compile(numberFormat).matcher(String.valueOf(studentBean.getBirthday())).matches();
                    if(!number){
                        throw new ServiceException("数字格式错误！");
                    }
                    //检查日期类型的数据格式
                }else if(propertyValueBean.getType()==2){
                    boolean date3 = Pattern.compile(dateFormat.toString()).matcher(String.valueOf(studentBean.getBirthday())).matches();
                    if(!date3){
                        throw new ServiceException("日期格式错误！");
                    }
                }
            }

            for(int i=0;i<num;i++){
                //TODO  这里面的a2,a3格式化格式是固定的，你这样写，假如num为1000，a2,a3分别得声明并生成1000次，声明并创建，循环一次还得回收！！！
                studentBean.getPropertyValueBeanList().get(i).setStudentId(studentId);//TODO 这行代码可读性太差
                //检查数字类型的数据格式
                if( studentBean.getPropertyValueBeanList().get(i).getType()==1){//TODO 这行代码可读性太差
                    String a2 = "[0-9]";//TODO 命名不规范，a2是什么鬼,而且为什么生成不用
                    boolean number = Pattern.compile(a1).matcher(String.valueOf(studentBean.getBirthday())).matches();
                    if(!number){
                        throw new ServiceException("数字格式错误！");
                    }
                    //检查日期类型的数据格式
                }else if(studentBean.getPropertyValueBeanList().get(i).getType()==2){//TODO 这行代码可读性太差
                    String a3 = "[0-9]{4}[0-9]{2}[0-9]{2}";//TODO 命名不规范，a3是什么鬼,而且为什么生成不用
                    boolean date3 = Pattern.compile(a1).matcher(String.valueOf(studentBean.getBirthday())).matches();
                    if(!date3){
                        throw new ServiceException("日期格式错误！");
                    }
                }
                //TODO 没有考虑value的大小限制，假如用户输入的文本1000位，会怎样？是不是应该提醒用户某个字段长度限制问题
            }
            studentMapper.addPropertyValue(studentBean.getPropertyValueBeanList());
        } else {
            throw new ServiceException("该学生已添加，添加失败!");
        }
    }

    @Override
    public void delete(String id) {
            if (!ObjectUtils.isEmpty(id)) {
                studentMapper.deleteById(id);
            } else {
                throw new ServiceException("学生信息不存在，删除失败!");
            }
        }

    @Override
    public Student detail(String id) {
        if (!ObjectUtils.isEmpty(id)) {
            return null;
        } else {
            throw new ServiceException("指标不存在，查询失败!");
        }
    }

}
