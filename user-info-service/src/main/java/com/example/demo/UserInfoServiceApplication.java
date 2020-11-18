package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableEurekaClient

@Transactional
@Service
@ComponentScan(basePackages = {"com.example.demo"})
@EnableJpaRepositories(basePackages = {"com.example.demo"})
@EntityScan(basePackages = {"com.example.demo"})
//@EntityScan(basePackages)={"com.example.demo"})

public class UserInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserInfoServiceApplication.class, args);
	}

}
