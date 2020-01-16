package com.ltt.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ltt.demo.common.common.Const;
import com.ltt.demo.common.common.exception.ServiceException;
import com.ltt.demo.entity.Property;
import com.ltt.demo.mapper.PropertyMapper;
import com.ltt.demo.service.PropertyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ltt.demo.common.common.Const.COMMON_COMPANY_ID;

import java.util.List;
import java.sql.Wrapper;
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
        //指标名称不能重复（企业和机构可以同时存在相同的指标名称）
        Property oldProperty = propertyMapper.selectOne(Wrappers.<Property>lambdaQuery()
                .eq(Property::getName, property.getName())
                .in(Property::getCompanyId, COMMON_COMPANY_ID, companyId)
        );

        if (ObjectUtils.isEmpty(oldProperty)) {
            long lastUpdateTimestamp = System.currentTimeMillis();
            property.setLastUpdateTimestamp(lastUpdateTimestamp);
            property.setCompanyId(companyId);
            property.setCanEdit(Const.AdminConst.CAN_EDIT);
			 propertyMapper.insert(property);
		} else {
            throw new ServiceException("指标名称重复，添加失败!");
        }
    }

    @Override
    public void delete(String id) {
        if (!ObjectUtils.isEmpty(id)) {
            propertyMapper.deleteById(id);
        } else {
            throw new ServiceException("指标不存在，删除失败!");
        }
    }
    @Override
    public List<Property> detail(String name) {
        if (!ObjectUtils.isEmpty(name)) {
            QueryWrapper<Property> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", name);
            return  propertyMapper.selectList( queryWrapper);

        } else {
            throw new ServiceException("指标不存在，查询失败!");
        }
    }
    @Override
    public void edit(Property property) {
        if (!ObjectUtils.isEmpty(property)) {
            UpdateWrapper<Property> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("name", property.getName());
            /*updateWrapper.eq("can_edit", property.getCanEdit());
            updateWrapper.eq("code", property.getCode());
            updateWrapper.eq("company_id", property.getCompanyId());
            updateWrapper.eq("last_update_timestamp", property.getLastUpdateTimestamp());
            updateWrapper.eq("type", property.getType());
            updateWrapper.eq("order_num", property.getOrderNum());*/
            propertyMapper.update(property,updateWrapper);
        } else {
            throw new ServiceException("指标不存在，修改失败!");
        }
    }
}
