package org.springbootproject.hospitalspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.springbootproject.hospitalspringapp")
public class HospitalSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalSpringAppApplication.class, args);
	}

}
