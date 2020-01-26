package com.ltt.demo.controller;


import com.ltt.demo.bean.PropertyValueBean;
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
        //TODO 删除不能分两个函数写，假如删除学生表成功了，删动态表失败了，就会错乱，而且要用事务
        studentService.delete(id);
        propertyValueService.delete(id);
        return successResult();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody StudentBean studentBean) {
        //TODO 在前端传参数的时候用Validated校验，在逻辑层就不用校验了，参考Property.java
        studentService.add(studentBean);
      /*  propertyValueService.add(studentBean);*/
        return successResult();
    }
}
