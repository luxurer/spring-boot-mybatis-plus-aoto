package com.ltt.demo.mapper;

import com.ltt.demo.bean.PropertyValueBean;
import com.ltt.demo.bean.StudentBean;
import com.ltt.demo.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuwei
 * @since 2020-01-06
 */
public interface StudentMapper extends BaseMapper<Student> {
   // StudentBean FindStudent(StudentBean studentBean);
   // String getStudentId(Student student);
    void addStudent(Student student);
    void addPropertyValue(List<PropertyValueBean> list);
}
