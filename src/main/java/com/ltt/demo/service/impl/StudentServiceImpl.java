package com.ltt.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ltt.demo.bean.StudentBean;
import com.ltt.demo.common.common.Const;
import com.ltt.demo.common.common.exception.ServiceException;
import com.ltt.demo.entity.Property;
import com.ltt.demo.entity.Student;
import com.ltt.demo.mapper.PropertyMapper;
import com.ltt.demo.mapper.StudentMapper;
import com.ltt.demo.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional
    public void add(StudentBean studentBean) {
        // TODO 长度判断可以使用@Length注解
        if (studentBean.getName().length() > 20) {
            throw new ServiceException("名字不能大于20个字!");
        }
        //学生名字为空则不入库
        if (StringUtils.isEmpty(studentBean.getName())) {
            return;
        }
        //指标名称不能重复（企业和机构可以同时存在相同的指标名称）

        Student oldStudent = studentMapper.selectOne(Wrappers.<Student>lambdaQuery()
                .eq(Student::getSno, studentBean.getSno())
        );

        Student student=new Student();
        if (ObjectUtils.isEmpty(oldStudent)) {
            long lastUpdateTimestamp = System.currentTimeMillis();
            student.setLastUpdateTimestamp(lastUpdateTimestamp);
            student.setCompanyId(studentBean.getCompanyId());
            student.setSex(studentBean.getSex());
            student.setOrderNum(1);
            student.setBirthday(studentBean.getBirthday());
            student.setSno(studentBean.getSno());
            studentMapper.insert(student);


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
