package com.pinaki.MyBlogger;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyBloggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBloggerApplication.class, args);
		System.out.println("...... Welcome to MyBlogger ......");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
