package com.chy.oa.core.service.impl;

import com.chy.oa.base.pluging.Page;
import com.chy.oa.core.entity.Role;
import com.chy.oa.core.mapper.RoleMapper;
import com.chy.oa.core.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> queryAllRole(Page page) {
        return roleMapper.queryAllRole(page);
    }
}
