package com.chy.oa.core.controller;

import com.chy.oa.base.pluging.Page;
import com.chy.oa.core.entity.Department;
import com.chy.oa.core.service.IDepartmentService;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/dep")
@SessionAttributes("page")
public class DepController {
    @Autowired
    private IDepartmentService departmentService;

//    查询所有的部门

    @RequestMapping("deplist")
    public String queryDepList(Model model, Page page, HttpServletRequest request){
        List<Department> departments = departmentService.queryDepList(page);
        model.addAttribute("departments",departments);
        model.addAttribute("page",page);
        return "/dep/deplist";
    }

    /**
     * 通过ID删除部门
     * */
    @RequestMapping("depdel")
    public String deleteDep(int id){
        departmentService.deleteDep(id);
        return "redirect:/dep/deplist";
    }

    /**
     * 通过ID修改部门跳转至修改页面
     * */
    @RequestMapping("edit")
    public String editDep(int id,Model model){
        Department department = departmentService.queryDepById(id);
        model.addAttribute("deps",department);
        return "/dep/editDep";
    }

    /**
     * 通过ID修改部门
     * */
    @RequestMapping("update")
    public String updateDep(int id,  int pid, String name, String ddesc){
        System.out.println("id:"+id+" pid:"+pid+" name:"+name);
        departmentService.updateDep(id,pid,name,ddesc);
        return "redirect:/dep/deplist";
    }

    /**
     * 添加一条数据
     * */
    @RequestMapping("depinsert")
    public String insertDep(){
        return "/dep/depinsert";
    }

    @RequestMapping("insert")
    public String insert(int pid,String dname,String ddesc,int orderfield){
        departmentService.insert(pid,dname,ddesc,new Date(),orderfield);
        return "redirect:/dep/deplist";
    }

    /**
     * 添加部门 save
     * */
    @RequestMapping("save")
    public String save(Department department,String dname){

       System.out.println(department.getDname());
        departmentService.save(department);

        System.out.println("department end");
        return "redirect:/dep/deplist";
    }

    @ResponseBody
    @RequestMapping("queryAllJson")
    public List<Department> queryAllJson(){
        List<Department> departments = departmentService.queryDepList(null);
        System.out.println(departments);
        return departments;
    }
}
