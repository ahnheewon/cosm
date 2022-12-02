package com.prj.cosm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan(basePackages = "com.prj.cosm.**.mapper")
@SpringBootApplication
@ComponentScan(basePackages = {"com.prj"})
@EnableScheduling
public class CosmApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CosmApplication.class, args);
	}

}
