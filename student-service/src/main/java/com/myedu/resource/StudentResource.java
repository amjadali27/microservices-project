package com.myedu.resource;

import com.myedu.response.StudentResponse;
import com.myedu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentResource {

    @Autowired
    StudentService studentService;

    @RequestMapping("/student")
    public StudentResponse getStudent(){
       return studentService.getStudentResponse();
    }

}
