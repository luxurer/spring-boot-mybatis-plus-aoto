package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.entity.Property;
import com.example.mybatisplus.mapper.PropertyMapper;
import com.example.mybatisplus.service.PropertyService;
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
