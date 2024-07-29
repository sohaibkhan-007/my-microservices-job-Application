package com.job.app.company;

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
import org.springframework.web.bind.annotation.RestController;

import com.job.app.Dto.CompanyReviewDto;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private CompanyServices companyServices;

	public CompanyController(CompanyServices companyServices) {
		this.companyServices = companyServices;
	}

	@GetMapping
	public ResponseEntity<List<CompanyReviewDto>> getAllCompanies() {
		return ResponseEntity.ok(companyServices.getAllCompanies());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id) {
		Company company = companyServices.getCompanyById(id);
		if (company != null)
			return new ResponseEntity<>(company, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		Boolean saved = companyServices.createCompany(company);
		if (saved == true)
			return new ResponseEntity<>("Company Added Succesfully", HttpStatus.CREATED);
		return new ResponseEntity<>("failed, try again", HttpStatus.EXPECTATION_FAILED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@RequestBody Company company, @PathVariable("id") Long id) {
		Boolean updated = companyServices.updateCompany(company, id);
		if (updated == true)
			return new ResponseEntity<>("Company Updated Succesfully", HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable("id") Long id) {
		Boolean deleted = companyServices.deleteCompany(id);
		if (deleted)
			return new ResponseEntity<>("company deleted succesfully", HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
