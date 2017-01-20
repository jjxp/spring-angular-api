package com.sprouts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.sprouts.controller.WebController;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters=false)  // Disable component scanner
public class WebServer {

    public static void main(String[] args) {
        // Will configure using web-server.yml
        System.setProperty("spring.config.name", "web-server");
        SpringApplication.run(WebServer.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebController accountsController() {
         // 1. Value should not be hard-coded, just to keep things simple
         //        in this example.
         // 2. Case insensitive: could also use: http://accounts-service
         return new WebController
                       ("http://localhost:2222");  // serviceUrl
    }
}