package com.iLogApp.logisticApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.iLogApp.logisticApp.com.repositories")
public class LogisticAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticAppApplication.class, args);
	}

}
