package com.cov;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cov.beans.Department;
import com.cov.repo.DepartmentRepo;
import com.cov.repo.EmployeeRepo;

@SpringBootApplication
public class SpringJpaOtmDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOtmDemoApplication.class, args);
		
		}
}
