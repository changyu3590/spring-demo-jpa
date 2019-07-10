package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.springframework.boot.SpringApplication.run;
/**
 * @Author: ChangYu
 * @Version 1.0
 */
@SpringBootApplication
@EnableScheduling
@EnableSwagger2
@EnableJpaAuditing
public class SpringDemoApplication {

	public static void main(String[] args) {
		run(SpringDemoApplication.class, args);
	}



}

