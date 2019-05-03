package com.chy.oa.core.mapper;

import com.chy.oa.base.pluging.Page;
import com.chy.oa.core.entity.Role;

import java.util.List;

public interface RoleMapper {
     List<Role> queryAllRole(Page page);
}
