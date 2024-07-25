package com.job.app.externals;

public class Company {

	private Long id;
	private String name;
	private String description;
	private Long jobId;
	private Long reviewId;

	public Long getId() {
		return id;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description2) {
		this.description = description2;

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name2) {
		this.name = name2;
	}

}