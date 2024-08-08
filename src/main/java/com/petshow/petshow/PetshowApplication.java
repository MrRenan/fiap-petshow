package com.petshow.petshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//		(exclude = {SecurityAutoConfiguration.class})
public class PetshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetshowApplication.class, args);
	}

}
