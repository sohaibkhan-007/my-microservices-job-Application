package com.job.app.company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Long jobId;

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

	private Long reviewId;
	private Double rating;

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
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