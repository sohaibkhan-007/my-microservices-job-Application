package com.job.app.Dto;

import com.job.app.company.Company;
import com.job.app.externals.Review;

public class CompanyReviewDto {
	
	private Company company;
	private Review review;
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	
	

}
