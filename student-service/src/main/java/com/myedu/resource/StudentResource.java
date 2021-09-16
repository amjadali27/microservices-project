package com.myedu.resource;

import com.myedu.model.Student;
import com.myedu.response.Department;
import com.myedu.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
public class StudentResource {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @RequestMapping("/student")
    public StudentResponse getStudent(){
        StudentResponse response = new StudentResponse();
        Student student = new Student(1,"Amjad Ali","amjad@gmail.com","02-10-1998",2);
        response.setStudent(student);
        Department department = restTemplate.getForObject("http://department-service/department/"+student.getDepartmentId(),Department.class);

        /*
        ----- WEB CLIENT Alternative of REST TEMPLATE-----
        *****  REST TEMPLTE IS GOING TO DEPRICATE SOON ****

        Department department  = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/department/"+student.getDepartmentId())
                .retrieve()
                .bodyToMono(Department.class)
                .block();

         */

        response.setDepartment(department);
        return response;
    }

}
