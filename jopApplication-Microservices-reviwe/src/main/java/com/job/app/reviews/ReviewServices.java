package com.job.app.reviews;

import java.util.List;
import java.util.Optional;

public interface ReviewServices {

	Boolean addReview(Long companyId, Review review);

	List<Review> getAllReviewsByCompanyId(Long companyId);

	Optional<Review> getReviewById(Long reviewId);

	Boolean updateReviewById(Review updatedReview, Long reviewId);

	Boolean deleteById(Long reviewId);

}
