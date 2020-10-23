package com.java.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PortalServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalServerApplication.class, args);
	}

}
