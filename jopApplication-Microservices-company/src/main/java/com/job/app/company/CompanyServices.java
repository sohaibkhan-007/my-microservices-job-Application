package com.job.app.company;

import java.util.List;

import com.job.app.Dto.CompanyReviewDto;
import com.job.app.Dto.ReviewMessage;

public interface CompanyServices {

	List<CompanyReviewDto> getAllCompanies();

	Boolean createCompany(Company company);

	Boolean updateCompany(Company company, Long id);

	Boolean deleteCompany(Long id);

	Company getCompanyById(Long id);

	void updateCompanyRating(ReviewMessage reviewMessage);
}
