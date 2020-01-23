package com.ltt.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ltt.demo.bean.Attribute;
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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ltt.demo.common.common.Const.COMMON_COMPANY_ID;

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
    private PropertyMapper propertyMapper;
    private Property property;
    private StudentMapper studentMapper;
    private Student student;
    @Override
    public void add(StudentBean studentBean) {
        List<Attribute> list=studentBean.getList();
        int num1=list.size();
        List<PropertyValue> propertyValueList=new ArrayList<PropertyValue>();

        QueryWrapper<Student> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("sno", studentBean.getStudent().getSno());
        student= studentMapper.selectOne( queryWrapper2);

        for(int i=0;i<num1;i++){
            QueryWrapper<Property> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("name", list.get(i).getName());
            property= propertyMapper.selectOne( queryWrapper1);

            PropertyValue propertyValue=new PropertyValue();
            propertyValue.setValue(list.get(i).getValue());
            propertyValue.setCode(property.getCode());
            propertyValue.setStudentId(student.getId());
            propertyValueList.add(propertyValue);
        }

        PropertyValue propertyValue=new PropertyValue();
        int num2=propertyValueList.size();
        for(int i=0;i<num2;i++){
            //指标名称不能重复（企业和机构可以同时存在相同的指标名称）
            PropertyValue oldPropertyValue = propertyValueMapper.selectOne(Wrappers.<PropertyValue>lambdaQuery()
                    .eq(PropertyValue::getStudentId, propertyValue.getStudentId())
                    .eq(PropertyValue::getValue, propertyValue.getValue())
                    .eq(PropertyValue::getCode, propertyValue.getCode())
            );
            if (ObjectUtils.isEmpty(oldPropertyValue)) {
            propertyValue.setCode(propertyValueList.get(i).getCode());
            propertyValue.setStudentId(propertyValueList.get(i).getStudentId());
            propertyValue.setValue(propertyValueList.get(i).getValue());
            propertyValueMapper.insert(propertyValue);
            }
            else{
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
