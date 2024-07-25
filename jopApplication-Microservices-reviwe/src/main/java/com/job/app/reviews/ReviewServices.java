package com.job.app.reviews;

import java.util.List;

public interface ReviewServices {

	Boolean addReview(Long companyId, Review review);

	List<Review> getAllReviewsByCompanyId(Long companyId);

	Review getReviewById(Long reviewId);

	Boolean updateReviewById(Review updatedReview, Long reviewId);

	Boolean deleteById(Long reviewId);

}
