package com.myBlog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyBlog11Application {

	public static void main(String[] args) {
		SpringApplication.run(MyBlog11Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();

	}

}
