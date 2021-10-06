package com.myedu.resource;

import com.myedu.model.Department;
import com.myedu.response.DepartmentResponse;
import com.myedu.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(DepartmentResource.class);

    @Autowired
    Environment environment;

    @Autowired
    DepartmentService service;

    @RequestMapping({"/","all"})
    public DepartmentResponse getAllDepartments(){
        logger.info("getting all departments call initiated from controller...");
        DepartmentResponse response = service.getAllDepartments();
        logger.info("getting all departments call completed!");
        return response;
    }

    @RequestMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Integer deptId){
        logger.info("get department with id call initiated from controller...");
        Department response = service.getDepartmentById(deptId);
        logger.info("get department with id call completed!");
        return response;
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
