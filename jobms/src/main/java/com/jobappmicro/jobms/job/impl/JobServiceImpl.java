package com.jobappmicro.jobms.job.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jobappmicro.jobms.job.Job;
import com.jobappmicro.jobms.job.JobRepository;
import com.jobappmicro.jobms.job.JobService;

@Service
public class JobServiceImpl implements JobService {
	//private List<Job> jobs=new ArrayList<>();
	JobRepository jobRepository;
	
	
	
	
	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAll() {
		
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		
		jobRepository.save(job);
		
	}

	@Override
	public Job getJobById(Long id) {
		return jobRepository.findById(id).orElse(null);
	}
	
	@Override
	public boolean deleteById(Long id) {
		try {
			jobRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean updatedJob(Long id,Job updatedJob) {
		Optional<Job>jobOptional=jobRepository.findById(id);
			if(jobOptional.isPresent()) {
				Job job=jobOptional.get();
				job.setTitle(updatedJob.getTitle());
				job.setDescription(updatedJob.getDescription());
				job.setMinSalary(updatedJob.getMinSalary());
				job.setMaxSalary(updatedJob.getMaxSalary());
				job.setLocation(updatedJob.getLocation());
				jobRepository.save(job);
				return true;
			}
		
		return false;
	}

	
	
	

}
