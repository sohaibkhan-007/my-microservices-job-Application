package com.job.app.company;

import java.util.List;

public interface CompanyServices {

    List<Company> getAllCompanies();

    Boolean createCompany(Company company);

    Boolean updateCompany(Company company, Long id);

    Boolean deleteCompany(Long id);

    Company getCompanyById(Long id);
}
