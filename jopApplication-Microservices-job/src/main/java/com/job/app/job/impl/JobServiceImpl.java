package com.job.app.job.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.job.app.dto.JobWithCompanyDto;
import com.job.app.externals.Company;
import com.job.app.job.Job;
import com.job.app.job.JobRepository;
import com.job.app.job.JobService;

@Service
public class JobServiceImpl implements JobService {

	JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public List<JobWithCompanyDto> findAll() {
		List<Job> jobs = jobRepository.findAll();
		return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	public JobWithCompanyDto convertToDto(Job job) {
		RestTemplate restTemplate = new RestTemplate();
		JobWithCompanyDto jobWIthCompanyDto = new JobWithCompanyDto();
		jobWIthCompanyDto.setJob(job);
		Company company = restTemplate.getForObject("http://localhost:8082/company/" + job.getCompanyId(),
				Company.class);
		jobWIthCompanyDto.setCompany(company);
		return jobWIthCompanyDto;
	}

	@Override
	public void createJob(Job job) {
		jobRepository.save(job);
	}

	@Override
	public Job getJobById(Long id) {
		return jobRepository.findById(id).orElse(null);
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
