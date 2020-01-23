package com.ltt.demo.service;

import com.ltt.demo.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

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
   // Student  detail(String  id);
   // void edit(Property property);
   // List<Property> list(PageBean pageBean, String companyId);
}
