package com.job.app.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.job.app.externals.Review;

@FeignClient(name = "review")
public interface ReviewClient {

	@GetMapping("/reviews")
	List<Review> getReviews(@RequestParam("companyId") Long companyId);
}
