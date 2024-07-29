package com.job.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.job.app.externals.Company;

@FeignClient(name = "JOPAPPLICATION-MICROSERVICES-COMPANY")
public interface CompanyClient {

	@GetMapping("/company/{id}")
	Company getCompany(@PathVariable("id") Long id);
}
