package com.ltt.demo.service;

import com.ltt.demo.bean.Attribute;
import com.ltt.demo.bean.StudentBean;
import com.ltt.demo.entity.PropertyValue;
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
public interface PropertyValueService extends IService<PropertyValue> {
    void add(StudentBean studentBean);
    void delete(String  studentId);
    //PropertyValue detail(String  id);
    // void edit(Property property);
    // List<Property> list(PageBean pageBean, String companyId);
}
