package com.ltt.demo.service;

import com.ltt.demo.common.common.bean.PageBean;
import com.ltt.demo.entity.Property;
import com.ltt.demo.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuwei
 * @since 2020-01-06
 */
public interface StudentService extends IService<Student> {

    void add(Student student);
    void delete(String  id);
    //Property detail(String  id);
   // void edit(Property property);
   // List<Property> list(PageBean pageBean, String companyId);
}
