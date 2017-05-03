package org.sprouts.backend;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EntityScan(basePackages = {"org.sprouts.model","org.sprouts.pojo"})
public class BackEndServer implements ApplicationRunner {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "backend-server");
		SpringApplication.run(BackEndServer.class, args);
	}

	public void run(ApplicationArguments arg0) throws Exception {
		// Leave empty or not, but do not remove
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)          
          .select()
          .apis(RequestHandlerSelectors.basePackage("org.sprouts.backend.controller"))
          .build();
    }

	@Bean
	public KieContainer kieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}

}