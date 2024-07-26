package com.job.app.company;

import java.util.List;

import com.job.app.Dto.CompanyReviewDto;

public interface CompanyServices {

	List<CompanyReviewDto> getAllCompanies();

	Boolean createCompany(Company company);

	Boolean updateCompany(Company company, Long id);

	Boolean deleteCompany(Long id);

	Company getCompanyById(Long id);
}
