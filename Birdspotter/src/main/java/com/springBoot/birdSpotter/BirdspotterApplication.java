package com.springBoot.birdSpotter;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import service.SpottedBirdService;
import service.SpottedBirdServiceImpl;
import validators.AddBirdValidator;

@SpringBootApplication
public class BirdspotterApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BirdspotterApplication.class, args);
	}

	@Bean
	public SpottedBirdService spottedBirdService() {
		return new SpottedBirdServiceImpl();
	}

	@Bean
	public AddBirdValidator addBirdValidator() {
		return new AddBirdValidator();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
		registry.addResourceHandler("/scripts/**").addResourceLocations("resources/scripts/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/403").setViewName("403");
	}

}
