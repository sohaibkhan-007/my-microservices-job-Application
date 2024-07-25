package com.job.app.reviews.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.app.company.Company;
import com.job.app.company.CompanyServices;
import com.job.app.reviews.ReviewServices;
import com.job.app.reviews.Reviews;
import com.job.app.reviews.ReviewsRepository;

@Service
public class ReviewServicesImpl implements ReviewServices {

	private ReviewsRepository reviewsRepository;

	private CompanyServices companyServices;

	public ReviewServicesImpl(ReviewsRepository reviewsRepository, CompanyServices companyServices) {
		this.reviewsRepository = reviewsRepository;
		this.companyServices = companyServices;
	}

	@Override
	public List<Reviews> getAllReviews() {
		return reviewsRepository.findAll();
	}

	@Override
	public void createReview(Reviews review) {
		reviewsRepository.save(review);
	}

	@Override
	public Reviews getReviewById(Long reviewId) {
		Optional<Reviews> optional = reviewsRepository.findById(reviewId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Boolean updateReviewById(Reviews reviews, Long id) {
		Optional<Reviews> reviewOptional = reviewsRepository.findById(id);
		if (reviewOptional.isPresent()) {
			Reviews newReviews = reviewOptional.get();
			newReviews.setCompany(reviews.getCompany());
			newReviews.setDescription(reviews.getDescription());
			newReviews.setId(reviews.getId());
			newReviews.setRating(reviews.getRating());
			newReviews.setTitle(reviews.getTitle());
			reviewsRepository.save(newReviews);
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteById(Long companyId, Long reviewId) {
		if (companyServices.getCompanyById(companyId) != null && reviewsRepository.existsById(reviewId)) {
			Reviews reviews = reviewsRepository.findById(reviewId).orElse(null);
			Company company = reviews.getCompany();
			company.getReview().remove(reviews);
			companyServices.updateCompany(company, companyId);
			reviewsRepository.deleteById(reviewId);
			return true;
		}
		return false;
	}

}
