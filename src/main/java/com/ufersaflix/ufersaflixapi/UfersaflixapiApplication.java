package com.ufersaflix.ufersaflixapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class UfersaflixapiApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(UfersaflixapiApplication.class, args);
	}

}
