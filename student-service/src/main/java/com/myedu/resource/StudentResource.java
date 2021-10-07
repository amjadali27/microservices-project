package com.myedu.resource;

import com.myedu.response.StudentResponse;
import com.myedu.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
public class StudentResource {

    Logger logger = LoggerFactory.getLogger(StudentResource.class);

    @Autowired
    StudentService studentService;

//    @Value("${config.value:defaultValue}")
//    private String configMessage;

    @RequestMapping("/get")
    public StudentResponse getStudent() {
        logger.info("getting student response call initiated from controller...");
        StudentResponse response  = studentService.getStudentResponse();
        logger.info("getting student response call completed!");
//        logger.info("---- CONFIG MESSAGE--- "+configMessage);
       return response;
    }


}
