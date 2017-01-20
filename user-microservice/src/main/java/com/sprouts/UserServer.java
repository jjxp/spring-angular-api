package com.sprouts;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.sprouts.util.PopulateDatabase;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaServer
public class UserServer implements ApplicationRunner {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "user-server");
		SpringApplication.run(UserServer.class, args);
	}

	public void run(ApplicationArguments arg0) throws Exception {
		PopulateDatabase.main(null);
	}

}