package com.myedu.resource;

import com.myedu.model.Department;
import com.myedu.response.DepartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentResource {

    @Autowired
    Environment environment;

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

    @RequestMapping("/environment-details")
    public String getEnvironmentDetails(){
        return "<h3>RESPONDING SERVICE IS RUNNING ON PORT : <p style = 'color:red'>"+ environment.getProperty("local.server.port")+"</p></h3>";
    }

    @RequestMapping("/get-message")
    public String getMessage(){
        return "Returning Message";
    }
}
