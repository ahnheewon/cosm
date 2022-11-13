package com.prj.cosm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(basePackages = "com.prj.cosm.**.mapper")
@SpringBootApplication
public class CosmApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CosmApplication.class, args);
	}
	
	

}
