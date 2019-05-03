package com.chy.oa.core.service;

import com.chy.oa.base.pluging.Page;
import com.chy.oa.core.entity.Department;

import java.util.Date;
import java.util.List;

public interface IDepartmentService {
    List<Department> queryDepList(Page page);
    int deleteDep(int id);
    Department queryDepById(int id);
    int updateDep(int id, int pid, String name, String ddesc);
    int insert(int pid,String dname,String ddesc,Date createtime,int orderfield);
    int save(Department department);
}
