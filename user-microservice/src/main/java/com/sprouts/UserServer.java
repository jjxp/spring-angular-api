package com.sprouts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.sprouts.controller.UserController;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters=false)
public class UserServer {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "user-server");
        SpringApplication.run(UserServer.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public UserController accountsController() {
         // 1. Value should not be hard-coded, just to keep things simple
         //        in this example.
         // 2. Case insensitive: could also use: http://accounts-service
         return new UserController
                       ("http://ACCOUNTS-SERVICE");  // serviceUrl
    }
    
}