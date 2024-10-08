package com.job.app.job.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.job.app.client.CompanyClient;
import com.job.app.client.ReviewClient;
import com.job.app.dto.JobDto;
import com.job.app.externals.Company;
import com.job.app.externals.Review;
import com.job.app.job.Job;
import com.job.app.job.JobRepository;
import com.job.app.job.JobService;
import com.job.app.mapper.JobMapper;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	RestTemplate restTemplate;

	JobRepository jobRepository;
	private CompanyClient companyClient;
	private ReviewClient reviewClient;
	private int attempts = 0;

	public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient) {
		this.jobRepository = jobRepository;
		this.companyClient = companyClient;
		this.reviewClient = reviewClient;
	}

	@Override
//	@CircuitBreaker(name = "companyBreaker", fallbackMethod = "companyBreakerFallback")
//	@Retry(name = "companyBreaker", fallbackMethod = "companyBreakerFallback")
	@RateLimiter(name = "companyBreaker", fallbackMethod = "companyBreakerFallback")
	public List<JobDto> findAll() {
		System.out.println("attempts " + ++attempts);
		List<Job> jobs = jobRepository.findAll();
		return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public List<String> companyBreakerFallback(Exception e) {
		List<String> list = new ArrayList<>();
		list.add("Dummy");
		return list;
	}

	public JobDto convertToDto(Job job) {
		Company company = companyClient.getCompany(job.getCompanyId());
		List<Review> reviews = reviewClient.getReviews(company.getReviewId());
		JobDto jobDto = JobMapper.mapToJobWithCompanyDto(job, company, reviews);
		return jobDto;
	}

	@Override
	public void createJob(Job job) {
		jobRepository.save(job);
	}

	@Override
	public JobDto getJobById(Long id) {
		Job job = jobRepository.findById(id).orElse(null);
		if (job != null) {
			return convertToDto(job);
		}
		return null;
	}

	@Override
	public Boolean deleteById(Long id) {
		try {
			if (jobRepository.existsById(id)) {
				jobRepository.deleteById(id);
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	@Override
	public Boolean updateJob(Long id, Job updatedJob) {
		Optional<Job> jobOptional = jobRepository.findById(id);
		if (jobOptional.isPresent()) {
			Job job = jobOptional.get();
			job.setDescription(updatedJob.getDescription());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setDescription(updatedJob.getDescription());
			job.setTitle(updatedJob.getTitle());
			job.setCompanyId(updatedJob.getCompanyId());
			jobRepository.save(job);
			return true;
		}
		return false;
	}
}
