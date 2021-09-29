package com.myedu.resource;

import com.myedu.response.StudentResponse;
import com.myedu.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentResource {

    Logger logger = LoggerFactory.getLogger(StudentResource.class);

    @Autowired
    StudentService studentService;

    @RequestMapping("/student")
    public StudentResponse getStudent(){
       return studentService.getStudentResponse();
    }

    @RequestMapping("/envo-details")
    public String getEnvoDetails() {
        return studentService.getEnvironmentDetails();
    }



}
