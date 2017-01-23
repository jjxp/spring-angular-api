package org.sprouts.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.sprouts.frontend.controller.WebController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@ComponentScan(useDefaultFilters=false)
public class FrontEndServer {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "frontend-server");
        SpringApplication.run(FrontEndServer.class, args);
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebController usersController() {
    	return new WebController("http://localhost:2222");
    }
    
    @Bean
    public Docket api() {                
        return new Docket(DocumentationType.SWAGGER_2)          
          .select()
          .apis(RequestHandlerSelectors.basePackage("org.sprouts.frontend.controller"))
          .paths(PathSelectors.ant("/user/*"))
          .build();
    }
}