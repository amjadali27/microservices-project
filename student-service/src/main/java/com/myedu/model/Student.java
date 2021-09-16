package com.myedu.model;

public class Student {

    private Integer id;
    private String name;
    private String email;
    private String dob;
    private Integer departmentId;

    public Student() {
    }

    public Student(Integer id, String name, String email, String dob, Integer departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
