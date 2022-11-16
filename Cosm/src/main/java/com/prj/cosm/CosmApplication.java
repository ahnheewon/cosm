package com.prj.cosm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan(basePackages = "com.prj.cosm.*.*.mapper")
@ComponentScan(basePackages = {"com.prj"})
public class CosmApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CosmApplication.class, args);
	}
	

	

}
