package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.demo")
@EntityScan(basePackages = "com.example.model")
@EnableJpaRepositories(basePackages = "com.example.repository")
public class EmployeeManagementApplication {

	public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

}
