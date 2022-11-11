package com.prj.cosm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CosmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmApplication.class, args);
	}
	
	@RequestMapping("/")
	String home() {
		return "cosm start";
	}

}
