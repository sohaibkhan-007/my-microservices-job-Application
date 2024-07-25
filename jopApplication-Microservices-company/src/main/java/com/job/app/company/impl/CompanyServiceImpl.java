package com.job.app.company.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.job.app.company.Company;
import com.job.app.company.CompanyRepository;
import com.job.app.company.CompanyServices;

@Service
public class CompanyServiceImpl implements CompanyServices {

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
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
}