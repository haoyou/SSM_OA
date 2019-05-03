package com.chy.oa.core.service;

import com.chy.oa.core.entity.Employee;

public interface IEmployeeService {
    Employee login(String name,String password);
}
