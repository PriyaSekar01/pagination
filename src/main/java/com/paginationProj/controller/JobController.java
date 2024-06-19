package com.paginationProj.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paginationProj.job.Job;
import com.paginationProj.service.JobService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class JobController {
	
	private final JobService jobService;
	
	  @GetMapping("/getAll")
	  private List<Job> getProducts() {
	        List<Job> allProducts = jobService.findAllProducts();
	        return allProducts; 	 
	  }

	    @GetMapping("/{field}")
	    private List<Job> getProductsWithSort(@PathVariable String field) {
	        List<Job> allProducts = jobService.findProductsWithSorting(field);
	        return allProducts;
	    }

	    @GetMapping("/pagination/{offset}/{pageSize}")
	    private Page<Job> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
	        Page<Job> productsWithPagination = jobService.findProductsWithPagination(offset, pageSize);
	        return productsWithPagination;
	    }

	    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
	    private Page<Job> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
	        Page<Job> productsWithPagination = jobService.findProductsWithPaginationAndSorting(offset, pageSize, field);
	        return productsWithPagination;
	    }


}
