package com.chy.oa.core.entity;

import java.util.Date;

public class Employee {
    private Integer id;
    private String email;//内部邮箱
    private String password; //邮箱密码
    private String name;
    private String phone;
    private Integer sex;
    private Date birthday;
    private String image;
    private String edesc;//个人介绍
    private Date entrytime;
    private Integer did;

    public Employee() {
    }

    public Employee(Integer id, String email, String password, String name, String phone, Integer sex, Date birthday, String image, String edesc, Date entrytime, Integer did) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.birthday = birthday;
        this.image = image;
        this.edesc = edesc;
        this.entrytime = entrytime;
        this.did = did;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEdesc() {
        return edesc;
    }

    public void setEdesc(String edesc) {
        this.edesc = edesc;
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", image='" + image + '\'' +
                ", edesc='" + edesc + '\'' +
                ", entrytime=" + entrytime +
                ", did=" + did +
                '}';
    }
}
