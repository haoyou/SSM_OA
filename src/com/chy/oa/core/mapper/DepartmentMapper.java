package com.chy.oa.core.mapper;

import com.chy.oa.base.pluging.Page;
import com.chy.oa.core.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DepartmentMapper {
    List<Department> queryDepList(Page page);
    int deleteDep(int id);
    Department queryDepById(int id);
    int updateDep(@Param("id") int id, @Param("pid") int pid,@Param("dname") String name, @Param("ddesc") String ddesc);
    int insert(@Param("pid") int pid,@Param("dname") String dname,
               @Param("ddesc") String ddesc,@Param("createtime") Date createtime,@Param("orderfield") int orderfield);
    int save(Department department);
}
