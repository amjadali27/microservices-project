package com.myedu.response;

import com.myedu.model.Department;

import java.util.List;

public class DepartmentResponse {
    private List<Department> departments;

    public DepartmentResponse() {
    }

    public DepartmentResponse(List<Department> departments) {
        this.departments = departments;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
