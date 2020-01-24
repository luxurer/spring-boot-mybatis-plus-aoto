package com.ltt.demo.controller;


import com.ltt.demo.bean.StudentBean;
import com.ltt.demo.common.common.bean.Result;
import com.ltt.demo.entity.Student;
import com.ltt.demo.service.PropertyValueService;
import com.ltt.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/admin/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private PropertyValueService propertyValueService;

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Result add(String id) {
        studentService.delete(id);
        propertyValueService.delete(id);
        return successResult();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody StudentBean studentBean) {
        Student student=new Student();
        student.setId(studentBean.getId());
        student.setName(studentBean.getName());
        student.setBirthday(studentBean.getBirthday());
        student.setSex(studentBean.getSex());
        student.setCompanyId(studentBean.getCompanyId());
        student.setSno(studentBean.getSno());
        student.setOrderNum(studentBean.getOrderNum());
        student.setLastUpdateTimestamp(studentBean.getLastUpdateTimestamp());
        studentService.add(student);
        propertyValueService.add(studentBean);
        return successResult();
    }
}
