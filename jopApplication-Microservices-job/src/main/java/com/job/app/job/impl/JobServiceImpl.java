package com.job.app.job.impl;

import java.io.Console;
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

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	RestTemplate restTemplate;

	JobRepository jobRepository;
	private CompanyClient companyClient;
	private ReviewClient reviewClient;

	public JobServiceImpl(JobRepository jobRepository, CompanyClient companyClient, ReviewClient reviewClient) {
		this.jobRepository = jobRepository;
		this.companyClient = companyClient;
		this.reviewClient = reviewClient;
	}

	@Override
	public List<JobDto> findAll() {
		List<Job> jobs = jobRepository.findAll();
		return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
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
