package com.chy.oa.core.controller;

import com.chy.oa.core.entity.Employee;
import com.chy.oa.core.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/index")
@SessionAttributes("user")
public class LoginController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping("/login")
    public String login(String email, String password, Model model){
        Employee employee = employeeService.login(email,password);
        if (employee != null){
            model.addAttribute("user",employee.getEmail());
            return "index/index";
        }
        model.addAttribute("error",1);
        return "/index/login";
    }

    @RequestMapping("/{packPath}/{jspPath}")
    public String toPage(@PathVariable String packPath, @PathVariable String jspPath){
        return "/"+packPath+"/"+jspPath;
    }
}
