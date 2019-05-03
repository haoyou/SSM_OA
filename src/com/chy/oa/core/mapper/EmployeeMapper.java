package com.chy.oa.core.mapper;

import com.chy.oa.core.entity.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    Employee login(@Param("email") String email,@Param("password") String password);
}
