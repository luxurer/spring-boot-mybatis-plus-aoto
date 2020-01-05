package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.entity.Role;
import com.example.mybatisplus.mapper.RoleMapper;
import com.example.mybatisplus.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huzhiting
 * @since 2020-01-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
