package com.paginationProj.service;



import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.paginationProj.job.Job;
import com.paginationProj.repository.JobRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobService {
	
	private final JobRepository repository;
	
	public List<Job> getAllJOb() {
		return repository.findAll();
	}

	public List<Job> findByField(String field) {
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	public Page<Job> findAllJobBySize(int offset, int pageSize) {
		return repository.findAll(PageRequest.of(offset, pageSize));
			
	}

	public Page<Job> findPaginationWithSort(int offset, int pageSize, String field) {
		return repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
	}
	
	public Page<Job> findAllJobs(PageRequest pageRequest) {
	    return repository.findAll(pageRequest);
	}

	public Page<Job> findPaginationWithSort(PageRequest pageRequest) {
	    return repository.findAll(pageRequest);
	}
	
//	@PostConstruct
//	public void initDB() {
//	    Random random = new Random();
//	    List<Job> jobs = IntStream.rangeClosed(1, 30)
//	            .mapToObj(i -> new Job("job" + i, "description", "company", random.nextInt(5000)))
//	            .collect(Collectors.toList());
//
//	    repository.saveAll(jobs);
//	}

}
