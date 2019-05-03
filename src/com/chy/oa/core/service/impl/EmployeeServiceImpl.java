package com.chy.oa.core.service.impl;

import com.chy.oa.core.entity.Employee;
import com.chy.oa.core.mapper.EmployeeMapper;
import com.chy.oa.core.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee login(String email, String password) {
        return employeeMapper.login(email,password);
    }
}
