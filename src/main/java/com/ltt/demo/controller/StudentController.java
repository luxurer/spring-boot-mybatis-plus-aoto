package com.ltt.demo.controller;


import com.ltt.demo.bean.StudentBean;
import com.ltt.demo.common.common.bean.Result;
import com.ltt.demo.service.PropertyService;
import com.ltt.demo.service.PropertyValueService;
import com.ltt.demo.service.StudentService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

import static com.ltt.demo.common.common.bean.Result.successResult;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuwei
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private PropertyValueService propertyValueService;

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public Result add(String id) {
        studentService.delete(id);
        propertyValueService.delete(id);
        return successResult();
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public Result add(StudentBean studentBean) {
        studentService.add(studentBean.getStudent());
        propertyValueService.add(studentBean.getList());
        return successResult();
    }
}
