package com.chy.oa.core.controller;

import com.chy.oa.base.pluging.Page;
import com.chy.oa.core.entity.Role;
import com.chy.oa.core.service.IRoleService;
import com.chy.oa.core.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleServiceImpl roleService;
    @RequestMapping("/rolelist")
    public String queryAllRole(Page page, Model model){
        List<Role> roles = roleService.queryAllRole(page);
        model.addAttribute("roles",roles);
        return "/role/rolelist";
    }
}
