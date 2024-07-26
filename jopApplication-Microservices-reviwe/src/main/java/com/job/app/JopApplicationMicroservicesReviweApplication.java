package com.job.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JopApplicationMicroservicesReviweApplication {

	public static void main(String[] args) {
		SpringApplication.run(JopApplicationMicroservicesReviweApplication.class, args);
	}

}
