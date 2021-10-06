package com.myedu.service;

import com.myedu.model.Student;
import com.myedu.response.Department;
import com.myedu.response.StudentResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name="getStudentResponse", fallbackMethod = "getStudentResponseFallback")
    public StudentResponse getStudentResponse(){
        logger.info("Getting student response call processing...");
        StudentResponse response = new StudentResponse();
        Student student = getStudent();
        response.setStudent(student);
        logger.info("Getting department service communication call initiated");
        Department department = restTemplate.getForObject("http://department-service/department/"+student.getDepartmentId(),Department.class);
        response.setDepartment(department);
        return response;
    }

    private Student getStudent() {
        return new Student(1,"Amjad Ali","amjad4dahri@gmail.com","02-10-1998",1);
    }

    private StudentResponse getStudentResponseFallback(Exception ex){
        logger.info("department service is temporarily down...please try again");
        StudentResponse response = new StudentResponse();
        Student student = getStudent();
        response.setStudent(student);
        return response;
    }

}
