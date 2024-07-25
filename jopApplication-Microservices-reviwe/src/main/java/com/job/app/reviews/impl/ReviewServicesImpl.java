package com.job.app.reviews.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.job.app.reviews.Review;
import com.job.app.reviews.ReviewServices;
import com.job.app.reviews.ReviewsRepository;

@Service
public class ReviewServicesImpl implements ReviewServices {

	private ReviewsRepository reviewsRepository;

	public ReviewServicesImpl(ReviewsRepository reviewsRepository) {
		this.reviewsRepository = reviewsRepository;

	}

	@Override
	public List<Review> getAllReviewsByCompanyId(Long companyId) {
		Long id = 1L;
		System.out.println(reviewsRepository.getAllReviewsByCompanyId(id));
		return reviewsRepository.getAllReviewsByCompanyId(companyId);
	}

	@Override
	public Boolean addReview(Long companyId, Review review) {
		if (companyId != null && review != null) {
			review.setCompanyId(companyId);
			reviewsRepository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public Review getReviewById(Long reviewId) {
		Optional<Review> optional = reviewsRepository.findById(reviewId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Boolean updateReviewById(Review updateReview, Long reviewId) {
		Review review = reviewsRepository.findById(reviewId).orElse(null);
		if (review != null) {
			review.setCompanyId(updateReview.getCompanyId());
			review.setDescription(updateReview.getDescription());
			review.setId(reviewId);
			review.setRating(updateReview.getRating());
			review.setTitle(updateReview.getTitle());
			reviewsRepository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteById(Long reviewId) {
		Review review = reviewsRepository.findById(reviewId).orElse(null);
		if (review != null) {
			reviewsRepository.delete(review);
			return true;
		}
		return false;
	}

}
