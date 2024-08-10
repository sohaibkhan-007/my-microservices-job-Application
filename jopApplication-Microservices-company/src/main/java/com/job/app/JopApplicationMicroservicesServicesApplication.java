package com.job.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JopApplicationMicroservicesServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JopApplicationMicroservicesServicesApplication.class, args);
	}

}
