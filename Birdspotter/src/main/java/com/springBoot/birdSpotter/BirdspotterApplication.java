package com.springBoot.birdSpotter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import service.SpottedBirdService;
import service.SpottedBirdServiceImpl;

@SpringBootApplication
public class BirdspotterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirdspotterApplication.class, args);
	}
	
	@Bean
	public SpottedBirdService spottedBirdService() {
		return new SpottedBirdServiceImpl();
	}

}
