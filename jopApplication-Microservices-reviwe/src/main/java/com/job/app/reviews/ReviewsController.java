package com.job.app.reviews;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

	private ReviewServices reviewServices;

	public ReviewsController(ReviewServices reviewServices) {
		this.reviewServices = reviewServices;
	}

	@GetMapping
	public ResponseEntity<List<Review>> getAllReviewsByCompanyId(@RequestParam Long companyId) {
		List<Review> reviewList = reviewServices.getAllReviewsByCompanyId(companyId);
		return new ResponseEntity<>(reviewList, HttpStatus.FOUND);
	}

	@PostMapping
	public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
		Boolean isSaved = reviewServices.addReview(companyId, review);
		if (isSaved) {
			return new ResponseEntity<>("Review Added Successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Review Added Successfully", HttpStatus.CREATED);
		}
	}

	@GetMapping("/{reviewId}")
	public ResponseEntity<Review> getReviewById(@PathVariable("reviewId") Long reviewId) {
		Review review = reviewServices.getReviewById(reviewId);
		if (review != null) {
			return new ResponseEntity<>(review, HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{reviewId}")
	public ResponseEntity<String> updateReview(@RequestBody Review review, @PathVariable("reviewId") Long reviewId) {
		if (reviewServices.updateReviewById(review, reviewId)) {
			return new ResponseEntity<>("Review Updated succesfully", HttpStatus.OK);
		}
		return new ResponseEntity<>("Review Updated succesfully", HttpStatus.EXPECTATION_FAILED);

	}

	@DeleteMapping("/{reviewId}")
	public ResponseEntity<String> deleteById(@PathVariable("reviewId") Long reviewId) {
		if (reviewServices.deleteById(reviewId)) {
			return new ResponseEntity<>("Review Deleted succesfully", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>("no such review found", HttpStatus.NOT_FOUND);
	}

}
