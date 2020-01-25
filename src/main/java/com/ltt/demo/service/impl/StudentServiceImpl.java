package com.ltt.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ltt.demo.bean.StudentBean;
import com.ltt.demo.common.common.exception.ServiceException;
import com.ltt.demo.entity.Student;
import com.ltt.demo.mapper.StudentMapper;
import com.ltt.demo.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            student = student.setSno(studentBean.getSno());
            studentMapper.addStudent(student);

            String studentId = student.getId();
            int num=studentBean.getPropertyValueBeanList().size();
            for(int i=0;i<num;i++){
                studentBean.getPropertyValueBeanList().get(i).setStudentId(studentId);
                //检查数字类型的数据格式
                if( studentBean.getPropertyValueBeanList().get(i).getType()==1){
                    String a2 = "[0-9]";
                    boolean number = Pattern.compile(a1).matcher(String.valueOf(studentBean.getBirthday())).matches();
                    if(!number){
                        throw new ServiceException("数字格式错误！");
                    }
                    //检查日期类型的数据格式
                }else if(studentBean.getPropertyValueBeanList().get(i).getType()==2){
                    String a3 = "[0-9]{4}[0-9]{2}[0-9]{2}";
                    boolean date3 = Pattern.compile(a1).matcher(String.valueOf(studentBean.getBirthday())).matches();
                    if(!date3){
                        throw new ServiceException("日期格式错误！");
                    }
                }
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
