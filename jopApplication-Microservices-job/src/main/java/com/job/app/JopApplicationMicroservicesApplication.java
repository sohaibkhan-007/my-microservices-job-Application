package com.job.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JopApplicationMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JopApplicationMicroservicesApplication.class, args);
	}

}
