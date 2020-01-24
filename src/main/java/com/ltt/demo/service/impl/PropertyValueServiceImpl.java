package com.ltt.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ltt.demo.bean.PropertyValueBean;
import com.ltt.demo.bean.StudentBean;
import com.ltt.demo.common.common.exception.ServiceException;
import com.ltt.demo.entity.Property;
import com.ltt.demo.entity.PropertyValue;
import com.ltt.demo.entity.Student;
import com.ltt.demo.mapper.PropertyMapper;
import com.ltt.demo.mapper.PropertyValueMapper;
import com.ltt.demo.mapper.StudentMapper;
import com.ltt.demo.service.PropertyValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuwei
 * @since 2020-01-06
 */
@Service
public class PropertyValueServiceImpl extends ServiceImpl<PropertyValueMapper, PropertyValue> implements PropertyValueService {
    @Autowired
    private PropertyValueMapper propertyValueMapper;
    @Autowired
    private PropertyMapper propertyMapper;
    @Autowired
    private StudentMapper studentMapper;

    private Property property;
    private Student student;


    @Override
    public void add(StudentBean studentBean) {

        List<PropertyValueBean> list=studentBean.getList();
        int num1=list.size();//属性个数

        QueryWrapper<Student> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("sno", studentBean.getSno());
        student= studentMapper.selectOne( queryWrapper2);

        for(int i=0;i<num1;i++){      //构造propertyValue
            QueryWrapper<Property> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("name", list.get(i).getCode()).eq("company_id",studentBean.getCompanyId());
            property= propertyMapper.selectOne( queryWrapper1);

            PropertyValue propertyValue=new PropertyValue();
            propertyValue.setValue(list.get(i).getValue());
            propertyValue.setCode(list.get(i).getCode());
            propertyValue.setStudentId(student.getId());


            //指标名称不能重复（企业和机构可以同时存在相同的指标名称）
            PropertyValue oldPropertyValue = propertyValueMapper.selectOne(Wrappers.<PropertyValue>lambdaQuery()
                    .eq(PropertyValue::getStudentId, propertyValue.getStudentId())
                    .eq(PropertyValue::getValue, propertyValue.getValue())
                    .eq(PropertyValue::getCode,propertyValue.getCode())
            );

            if (ObjectUtils.isEmpty(oldPropertyValue)) {
            propertyValueMapper.insert(propertyValue);
            }
            else{
                System.out.print("in PropertyValue");
                throw new ServiceException("该项学生信息已添加，添加失败!");
            }
        }
    }

    @Override
    public void delete(String studentId) {
        if (!ObjectUtils.isEmpty(studentId)) {
            QueryWrapper<PropertyValue> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("student_id", studentId);
            propertyValueMapper.delete(queryWrapper);
        } else {
            throw new ServiceException("学生信息不存在，删除失败!");
        }
    }
}
