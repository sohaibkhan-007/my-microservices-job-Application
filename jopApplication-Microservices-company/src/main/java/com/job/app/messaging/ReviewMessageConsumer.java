package com.job.app.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.job.app.Dto.ReviewMessage;
import com.job.app.company.CompanyServices;

@Service
public class ReviewMessageConsumer {

	private final CompanyServices companyServices;

	public ReviewMessageConsumer(CompanyServices companyServices) {
		this.companyServices = companyServices;
	}

	@RabbitListener(queues = "companyRatingQueue")
	public void consumeMessage(ReviewMessage reviewMessage) {
		companyServices.updateCompanyRating(reviewMessage);
	}

}
