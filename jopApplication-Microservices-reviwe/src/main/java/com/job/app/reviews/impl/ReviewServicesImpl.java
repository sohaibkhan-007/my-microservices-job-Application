package com.job.app.reviews.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.job.app.reviews.Review;
import com.job.app.reviews.ReviewServices;
import com.job.app.reviews.ReviewsRepository;

@Service
public class ReviewServicesImpl implements ReviewServices {

	private final ReviewsRepository reviewsRepository;

	public ReviewServicesImpl(ReviewsRepository reviewsRepository) {
		this.reviewsRepository = reviewsRepository;
	}

	@Override
	public List<Review> getAllReviewsByCompanyId(Long companyId) {
		return reviewsRepository.findAllByCompanyId(companyId);
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
	public Optional<Review> getReviewById(Long reviewId) {
		return reviewsRepository.findById(reviewId);
	}

	@Override
	public Boolean updateReviewById(Review updateReview, Long reviewId) {
		Optional<Review> optionalReview = reviewsRepository.findById(reviewId);
		if (optionalReview.isPresent()) {
			Review review = optionalReview.get();
			review.setCompanyId(updateReview.getCompanyId());
			review.setDescription(updateReview.getDescription());
			review.setRating(updateReview.getRating());
			review.setTitle(updateReview.getTitle());
			reviewsRepository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteById(Long reviewId) {
		Optional<Review> optionalReview = reviewsRepository.findById(reviewId);
		if (optionalReview.isPresent()) {
			reviewsRepository.delete(optionalReview.get());
			return true;
		}
		return false;
	}
}
