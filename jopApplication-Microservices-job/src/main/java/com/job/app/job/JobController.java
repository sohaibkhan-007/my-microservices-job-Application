package com.job.app.job;

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

import com.job.app.dto.JobWithCompanyDto;

@RestController
@RequestMapping("/jobs")
public class JobController {

	private JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping
	public ResponseEntity<List<JobWithCompanyDto>> findaAll() {
		return ResponseEntity.ok(jobService.findAll());
	}

	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		jobService.createJob(job);
		return new ResponseEntity<>("Job Added SuccessFully", HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable("id") Long id) {
		Job job = jobService.getJobById(id);
		if (job != null)
			return new ResponseEntity<>(job, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		Boolean deleted = jobService.deleteById(id);
		if (deleted) {
			return new ResponseEntity<>("Job Deleted Succesfully", HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateJob(@PathVariable("id") Long id, @RequestBody Job updatedJob) {
		Boolean updated = jobService.updateJob(id, updatedJob);
		if (updated)
			return new ResponseEntity<String>("job updated Successfully", HttpStatus.OK);
		return new ResponseEntity<String>("No Such Job Found", HttpStatus.NOT_FOUND);
	}
}