package com.job.app.dto;

import com.job.app.externals.Company;
import com.job.app.job.Job;

public class JobWithCompanyDto {

	private Job job;
	private Company company;

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
