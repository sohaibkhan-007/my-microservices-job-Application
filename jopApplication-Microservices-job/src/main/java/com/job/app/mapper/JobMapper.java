package com.job.app.mapper;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.job.app.dto.JobDto;
import com.job.app.externals.Company;
import com.job.app.externals.Review;
import com.job.app.job.Job;

public class JobMapper {

	public static JobDto mapToJobWithCompanyDto(Job job, Company company, List<Review> review) {
		JobDto jobWithCompanyDto = new JobDto();
		jobWithCompanyDto.setId(job.getId());
		jobWithCompanyDto.setDescription(job.getDescription());
		jobWithCompanyDto.setLocation(job.getLocation());
		jobWithCompanyDto.setTitle(job.getTitle());
		jobWithCompanyDto.setMaxSalary(job.getTitle());
		jobWithCompanyDto.setMinSalary(job.getMinSalary());
		jobWithCompanyDto.setCompany(company);
		jobWithCompanyDto.setReview(review);
		return jobWithCompanyDto;
	}

}
