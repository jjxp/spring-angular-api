package org.sprouts.backend;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.sprouts.backend.util.PopulateDatabase;

@SpringBootApplication
@EnableEurekaClient
public class BackEndServer implements ApplicationRunner {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "backend-server");
		SpringApplication.run(BackEndServer.class, args);
	}

	public void run(ApplicationArguments arg0) throws Exception {
		PopulateDatabase.main(null);
	}

}