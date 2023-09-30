package com.olp.eagle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.olp.impl","com.olp.controller"})
@EntityScan(basePackages = {"com.olp.entity"})
@EnableJpaRepositories(basePackages = "com.olp.repository")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class EagleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EagleApplication.class, args);
	}

}
