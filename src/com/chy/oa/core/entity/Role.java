package com.chy.oa.core.entity;

public class Role {
    private Integer id;
    private String rolename;
    private String rolealias;
    private String roledesc;
    private Integer rolestates;

    public Role() {
    }

    public Role(Integer id, String rolename, String rolealias, String roledesc, Integer rolestates) {
        this.id = id;
        this.rolename = rolename;
        this.rolealias = rolealias;
        this.roledesc = roledesc;
        this.rolestates = rolestates;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRolealias() {
        return rolealias;
    }

    public void setRolealias(String rolealias) {
        this.rolealias = rolealias;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public Integer getRolestates() {
        return rolestates;
    }

    public void setRolestates(Integer rolestates) {
        this.rolestates = rolestates;
    }
}
