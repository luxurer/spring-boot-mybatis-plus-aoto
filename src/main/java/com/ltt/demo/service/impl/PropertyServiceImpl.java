package com.ltt.demo.service.impl;

import com.ltt.demo.entity.Property;
import com.ltt.demo.mapper.PropertyMapper;
import com.ltt.demo.service.PropertyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuwei
 * @since 2020-01-06
 */
@Service
public class PropertyServiceImpl extends ServiceImpl<PropertyMapper, Property> implements PropertyService {

}
