package com.job.app.job;

import java.util.List;

import com.job.app.dto.JobDto;

public interface JobService {

	List<JobDto> findAll();

	void createJob(Job job);

	JobDto getJobById(Long id);

	Boolean deleteById(Long id);

	Boolean updateJob(Long id, Job updatedJob);
}