package org.sprouts.backend;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.sprouts.backend.util.PopulateDatabase;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class BackEndServer implements ApplicationRunner {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "backend-server");
		System.setProperty("spring.datasource.platform","mysql");
		System.setProperty("spring.datasource.url","jdbc:mysql://localhost:3306/sprouts-core");
		System.setProperty("spring.datasource.username","manager");
		System.setProperty("spring.datasource.password","root");
		System.setProperty("spring.jpa.hibernate.ddl-auto","update");
		System.setProperty("spring.jpa.hibernate.naming-strategy","org.hibernate.cfg.DefaultNamingStrategy");
		System.setProperty("spring.datasource.username","manager");
		System.setProperty("spring.jpa.properties.hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");

		SpringApplication.run(BackEndServer.class, args);
	}

	public void run(ApplicationArguments arg0) throws Exception {
		PopulateDatabase.main(null);
	}

}