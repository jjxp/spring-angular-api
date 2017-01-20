package com.sprouts;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.sprouts.util.PopulateDatabase;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class UserServer implements ApplicationRunner {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "user-server");
		System.setProperty("spring.datasource.platform","mysql");
		System.setProperty("spring.datasource.url","jdbc:mysql://localhost:3306/spring-angular-api");
		System.setProperty("spring.datasource.username","manager");
		System.setProperty("spring.datasource.password","root");
		System.setProperty("spring.jpa.hibernate.ddl-auto","update");
		System.setProperty("spring.jpa.hibernate.naming-strategy","org.hibernate.cfg.DefaultNamingStrategy");
		System.setProperty("spring.datasource.username","manager");
		System.setProperty("spring.jpa.properties.hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");

		SpringApplication.run(UserServer.class, args);
	}

	public void run(ApplicationArguments arg0) throws Exception {
		PopulateDatabase.main(null);
	}
	
//	@Bean
//	@Primary
//	public DataSource primaryDataSource() {
//	    return DataSourceBuilder.create().build();
//	}

}