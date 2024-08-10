package com.job.app.company.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.job.app.Dto.CompanyReviewDto;
import com.job.app.Dto.ReviewMessage;
import com.job.app.clients.ReviewClient;
import com.job.app.company.Company;
import com.job.app.company.CompanyRepository;
import com.job.app.company.CompanyServices;
import com.job.app.externals.Review;

import jakarta.ws.rs.NotFoundException;

@Service
public class CompanyServiceImpl implements CompanyServices {

	@Autowired
	private RestTemplate restTemplate;
	private ReviewClient reviewClient;

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository, ReviewClient reviewClient) {
		this.companyRepository = companyRepository;
		this.reviewClient = reviewClient;
	}

	@Override
	public List<CompanyReviewDto> getAllCompanies() {
		List<Company> companies = companyRepository.findAll();
		return companies.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	private CompanyReviewDto convertToDto(Company company) {
		CompanyReviewDto companyReviewDto = new CompanyReviewDto();
		companyReviewDto.setCompany(company);
		Review review = restTemplate.getForObject("http://review/reviews/" + company.getReviewId(), Review.class);
		companyReviewDto.setReview(review);
		return companyReviewDto;
	}

	@Override
	public Boolean createCompany(Company company) {
		try {
			companyRepository.save(company);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean updateCompany(Company company, Long id) {
		Optional<Company> optional = companyRepository.findById(id);
		if (!optional.isPresent()) {
			return false;
		}
		Company companyToUpdate = optional.get();
		companyToUpdate.setDescription(company.getDescription());
		companyToUpdate.setJobId(company.getJobId());
		companyToUpdate.setName(company.getName());
		companyToUpdate.setReviewId(company.getReviewId());
		companyRepository.save(companyToUpdate);
		return true;
	}

	@Override
	public Boolean deleteCompany(Long id) {
		Optional<Company> optional = companyRepository.findById(id);
		if (optional.get() != null) {
			companyRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Company getCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
	}

	public void updateCompanyRating(ReviewMessage reviewMessage) {
		Company company = companyRepository.findById(reviewMessage.getCompanyId())
				.orElseThrow(() -> new NotFoundException("Company not found with ID: " + reviewMessage.getCompanyId()));
		double averageRating = reviewClient.getAverageRatingForCompany(reviewMessage.getCompanyId());
		company.setRating(averageRating);
		companyRepository.save(company);
	}
}