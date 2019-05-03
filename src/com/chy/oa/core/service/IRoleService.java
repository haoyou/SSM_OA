package com.chy.oa.core.service;

import com.chy.oa.base.pluging.Page;
import com.chy.oa.core.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleService {
    List<Role> queryAllRole(Page page);
}
