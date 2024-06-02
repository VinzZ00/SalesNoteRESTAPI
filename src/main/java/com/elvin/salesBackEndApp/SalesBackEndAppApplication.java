package com.elvin.salesBackEndApp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SalesBackEndAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesBackEndAppApplication.class, args);
	}

	@Bean
	ModelMapper	modelMapper() {
		// Explicit bean with external library modelmapper to map the entity with dto and dto to entity
		return new ModelMapper();
	}
}
