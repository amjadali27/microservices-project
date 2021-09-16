package com.myedu.resource;

import com.myedu.model.Department;
import com.myedu.response.DepartmentResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentResource {

    @RequestMapping({"/","all"})
    public DepartmentResponse getAllDepartments(){

        List<Department> departments = Arrays.asList(
                new Department(1,"Software Engineering","MUET Jamshoro"),
                new Department(2,"Civil Engineering","MUET Khairpur"),
                new Department(3,"Mining Engineering","NED Karachi"),
                new Department(4,"Mechanical Engineering","MUET Jamshoro")
                );
        return new DepartmentResponse(departments);
    }

    @RequestMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Integer deptId){
        List<Department> departments = Arrays.asList(
                new Department(1,"Software Engineering","MUET Jamshoro"),
                new Department(2,"Civil Engineering","MUET Khairpur"),
                new Department(3,"Mining Engineering","NED Karachi"),
                new Department(4,"Mechanical Engineering","MUET Jamshoro")
        );
        return departments.stream().filter(department -> department.getId()==deptId).findFirst().get();
    }
}
