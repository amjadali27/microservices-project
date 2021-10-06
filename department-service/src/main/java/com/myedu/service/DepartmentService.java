package com.myedu.service;

import com.myedu.model.Department;
import com.myedu.resource.DepartmentResource;
import com.myedu.response.DepartmentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService {

    Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    public DepartmentResponse getAllDepartments(){
        logger.info("getting all departments call processing...");
        List<Department> departments = Arrays.asList(
                new Department(1,"Software Engineering","MUET Jamshoro"),
                new Department(2,"Civil Engineering","MUET Khairpur"),
                new Department(3,"Mining Engineering","NED Karachi"),
                new Department(4,"Mechanical Engineering","MUET Jamshoro")
        );
        return new DepartmentResponse(departments);
    }

    public Department getDepartmentById(Integer deptId){
        logger.info("get department with id call processing...");
        List<Department> departments = Arrays.asList(
                new Department(1,"Software Engineering","MUET Jamshoro"),
                new Department(2,"Civil Engineering","MUET Khairpur"),
                new Department(3,"Mining Engineering","NED Karachi"),
                new Department(4,"Mechanical Engineering","MUET Jamshoro")
        );
        return departments.stream().filter(department -> department.getId()==deptId).findFirst().get();
    }
}
