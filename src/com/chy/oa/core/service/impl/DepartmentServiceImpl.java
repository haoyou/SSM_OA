package com.chy.oa.core.service.impl;

import com.chy.oa.base.pluging.Page;
import com.chy.oa.core.entity.Department;
import com.chy.oa.core.mapper.DepartmentMapper;
import com.chy.oa.core.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> queryDepList(Page page) {
        return departmentMapper.queryDepList(page);
    }

    @Override
    public int deleteDep(int id) {
        return departmentMapper.deleteDep(id);
    }

    @Override
    public Department queryDepById(int id) {
        return departmentMapper.queryDepById(id);
    }

    @Override
    public int updateDep(int id, int pid, String name, String ddesc ) {
        return departmentMapper.updateDep(id,pid,name,ddesc);
    }

    @Override
    public int insert(int pid, String dname, String ddesc,Date createtime, int orderfield) {
        return departmentMapper.insert(pid,dname,ddesc,createtime,orderfield);
    }

    @Override
    public int save(Department department) {
        return departmentMapper.save(department);
    }
}
