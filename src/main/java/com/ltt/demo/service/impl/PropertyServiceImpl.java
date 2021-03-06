package com.ltt.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ltt.demo.common.common.Const;
import com.ltt.demo.common.common.bean.PageBean;
import com.ltt.demo.common.common.exception.ServiceException;
import com.ltt.demo.entity.Property;
import com.ltt.demo.entity.PropertyValue;
import com.ltt.demo.mapper.PropertyMapper;
import com.ltt.demo.mapper.PropertyValueMapper;
import com.ltt.demo.service.PropertyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ltt.demo.mapper.PropertyValueMapper;

import static com.ltt.demo.common.common.Const.COMMON_COMPANY_ID;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuwei
 * @since 2020-01-06
 */
@Service
public class PropertyServiceImpl extends ServiceImpl<PropertyMapper, Property> implements PropertyService {

    @Autowired
    private PropertyMapper propertyMapper;
    @Autowired
    private PropertyValueMapper propertyValueMapper;

    /***
     * @MethodName add
     * @Description 新增指标
     * @Author 刘伟
     * @Date 2019/12/3 15:59
     * @Exception
     *
     */
    @Override
    public void add(Property property) {
        String companyId = property.getCompanyId();
        // TODO 长度判断可以使用@Length注解
        if (property.getName().length() > 20) {
            throw new ServiceException("名字不能大于20个字!");
        }
        //指标名字为空则不入库
        if (StringUtils.isEmpty(property.getName())) {
            return;
        }
        //指标名称不能重复
        Property oldProperty = propertyMapper.selectOne(Wrappers.<Property>lambdaQuery()
                .eq(Property::getName, property.getName())
                .in(Property::getCompanyId, COMMON_COMPANY_ID, companyId)
        );

        if (ObjectUtils.isEmpty(oldProperty)) {
            long lastUpdateTimestamp = System.currentTimeMillis();
            property.setLastUpdateTimestamp(lastUpdateTimestamp);
            property.setCompanyId(companyId);
            property.setCode(getFieldCode());
            property.setCanEdit(Const.AdminConst.CAN_EDIT);
            propertyMapper.insert(property);
        } else {
            throw new ServiceException("指标名称重复，添加失败!");
        }
    }


    private synchronized String getFieldCode() {//生成code
        // TODO 该方法需要加上同步锁，防止并发问题
        String maxCode = propertyMapper.queryMaxCode();
        if (StringUtils.isBlank(maxCode)) {
            return "A000001";
        } else {
            Integer codeInt = Integer.valueOf(maxCode.substring(1));
            String newCode = String.valueOf(codeInt + 1);
            return completeCode(newCode);
        }

    }

    private String completeCode(String code) {
        StringBuilder codeBuilder = new StringBuilder(code);
        while (codeBuilder.length() < 6) {
            codeBuilder.insert(0, "0");//前插0
        }
        codeBuilder.insert(0, "A");//前插A
        return codeBuilder.toString();
    }


    @Override
    public void delete(String id) {
        QueryWrapper<Property> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("id", id);
        Property Property = propertyMapper.selectOne(queryWrapper1);

        QueryWrapper<PropertyValue> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("code", Property.getCode());
        List<PropertyValue> list = propertyValueMapper.selectList(queryWrapper2);

        if (!ObjectUtils.isEmpty(id) && list.size() == 0) {
            propertyMapper.deleteById(id);
        } else {
            throw new ServiceException("指标不存在，删除失败!");
        }
    }

    @Override
    public Property detail(String id) {
        if (!ObjectUtils.isEmpty(id)) {
            QueryWrapper<Property> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            return propertyMapper.selectOne(queryWrapper);
        } else {
            throw new ServiceException("指标不存在，查询失败!");
        }
    }

    @Override
    public void edit(Property property) {
        if (!ObjectUtils.isEmpty(property.getId())) {
            //指标名称不能重复
            Property oldProperty = propertyMapper.selectOne(Wrappers.<Property>lambdaQuery()
                    .eq(Property::getName, property.getName())
                    .in(Property::getCompanyId, COMMON_COMPANY_ID, property.getCompanyId())
            );
            if (ObjectUtils.isNotEmpty(oldProperty)) {
                //判断是否未修改
                if (property.getId().equals(oldProperty.getId())) {
                    return;
                } else {
                    //判断指标名称是否重复
                    throw new ServiceException("指标名称重复，添加失败!");
                }
            }
            UpdateWrapper<Property> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", property.getId());
            propertyMapper.update(property, updateWrapper);
        } else {
            throw new ServiceException("指标不存在，修改失败!");
        }
    }

    @Override
    public List<Property> list(PageBean pageBean, String companyId) {
        pageBean.setTotal((long) propertyMapper.selectCount(new QueryWrapper<Property>().eq("company_id", companyId)));
        IPage<Property> propertytIPage = new Page<Property>(pageBean.getPageNo(), pageBean.getPageSize(), pageBean.getTotal());
        IPage<Property> propertyList = propertyMapper.selectPage(propertytIPage, new QueryWrapper<Property>().eq("company_id", companyId));
        System.out.println("所属学校" + companyId);
        System.out.println("总页数" + propertyList.getPages());
        System.out.println("总记录数" + propertyList.getTotal());
        List<Property> list = propertyList.getRecords();
        return list;
    }

}
