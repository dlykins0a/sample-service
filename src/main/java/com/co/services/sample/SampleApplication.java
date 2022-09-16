package com.co.services.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		System.out.println(String.format("The current shell is: %s.", System.getenv("DBNAME")))
		SpringApplication.run(SampleApplication.class, args);
	}
	
}
