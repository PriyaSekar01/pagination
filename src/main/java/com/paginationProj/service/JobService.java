package com.paginationProj.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.paginationProj.job.Job;
import com.paginationProj.repository.JobRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobService {
	
	private final JobRepository repository;
	
	
	  public List<Job> findAllProducts() {
	        return repository.findAll();
	    }


	    public List<Job> findProductsWithSorting(String field){
	        return  repository.findAll(Sort.by(Sort.Direction.ASC,field));
	    }


	    public Page<Job> findProductsWithPagination(int offset,int pageSize){
	        Page<Job> products = repository.findAll(PageRequest.of(offset, pageSize));
	        return  products;
	    }

	    public Page<Job> findProductsWithPaginationAndSorting(int offset,int pageSize,String field){
	        Page<Job> products = repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
	        return  products;
	    }

}
