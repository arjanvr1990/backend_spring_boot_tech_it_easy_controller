package com.novi.backend_spring_boot_tech_it_easy_controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/api")
public class BackendSpringBootTechItEasyControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendSpringBootTechItEasyControllerApplication.class, args);
	}

}
