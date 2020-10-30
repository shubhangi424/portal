package com.java.demo;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableEurekaClient

@Transactional
@Service
@ComponentScan(basePackages = {"com.java.demo"})
@EnableJpaRepositories(basePackages = {"com.java.demo"})
@EntityScan(basePackages = {"com.java.demo"})


public class UserInfoServiceApplication {
		
	 
	 	public static void main(String[] args) {
		SpringApplication.run(UserInfoServiceApplication.class, args);
	}

}
