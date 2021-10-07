package com.myedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }


    /**
     * This method is used for now. But I will be using it in future. Basically this method
     * write to restriction of write api(put,post,delete) access to particular url.
     * @param builder
     * @return RouteLocator
     */
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder)  {
//        return builder.routes()
//                .route("path_route", r -> r.path("/student").and().method("POST", "PUT", "DELETE").and().host("myedu.com")
//                        .uri("http://localhost:8081"))
//                .route("path_route", r -> r.path("/student/**").and().method("GET")
//                        .uri("http://localhost:8082"))
//                .build();
//    }
}
