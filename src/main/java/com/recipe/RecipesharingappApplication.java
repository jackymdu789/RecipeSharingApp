package com.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("http://127.0.0.1:5500")
public class RecipesharingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesharingappApplication.class, args);
	}

}
