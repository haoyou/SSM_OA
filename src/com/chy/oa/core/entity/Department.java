package com.chy.oa.core.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Department {
    private Integer id;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    private Integer pid;
    private String  dname;
    private String ddesc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;
    private Integer orderfield;

    public Department() {
    }

    public Department(Integer id, Integer pid, String dname, String ddesc, Date createtime, Integer orderfield) {
        this.id = id;
        this.pid = pid;
        this.dname = dname;
        this.ddesc = ddesc;
        this.createtime = createtime;
        this.orderfield = orderfield;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }



    public String getDdesc() {
        return ddesc;
    }

    public void setDdesc(String ddesc) {
        this.ddesc = ddesc;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getOrderfield() {
        return orderfield;
    }

    public void setOrderfield(Integer orderfield) {
        this.orderfield = orderfield;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + dname + '\'' +
                ", ddesc='" + ddesc + '\'' +
                ", createtime=" + createtime +
                ", orderfield=" + orderfield +
                '}';
    }
}
