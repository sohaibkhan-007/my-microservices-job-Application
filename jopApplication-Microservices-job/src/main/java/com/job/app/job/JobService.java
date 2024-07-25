package com.job.app.job;

import java.util.List;

import com.job.app.dto.JobWithCompanyDto;

public interface JobService {

	List<JobWithCompanyDto> findAll();

	void createJob(Job job);

	Job getJobById(Long id);

	Boolean deleteById(Long id);

	Boolean updateJob(Long id, Job updatedJob);
}