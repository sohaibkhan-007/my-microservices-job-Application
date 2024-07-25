package com.job.app.reviews;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewsRepository extends JpaRepository<Review, Long> {

	@Query("SELECT r FROM review r WHERE r.companyId = :companyId")
	List<Review> getAllReviewsByCompanyId(Long companyId);

}
