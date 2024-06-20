package com.paginationProj.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;


import com.paginationProj.job.Job;
import com.paginationProj.service.JobService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;
    private final PagedResourcesAssembler<Job> pagedResourceAssembler;

    @GetMapping("/getAll")
    public List<Job> getAll() {
        return jobService.getAllJOb();
    }

    @GetMapping("/get-{field}")
    public List<Job> getByField(@PathVariable String field) {
        return jobService.findByField(field);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public PagedModel<EntityModel<Job>> getJobs(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Job> allJobs = jobService.findAllJobs(PageRequest.of(offset, pageSize));
        return pagedResourceAssembler.toModel(allJobs);
    }

    @GetMapping("/paginationWithSort/{offset}/{pageSize}/{field}")
    public PagedModel<EntityModel<Job>> getPaginationWithSort(@PathVariable int offset, 
                                                              @PathVariable int pageSize, 
                                                              @PathVariable String field) {
        Page<Job> jobs = jobService.findPaginationWithSort(PageRequest.of(offset, pageSize, Sort.by(field)));
        return pagedResourceAssembler.toModel(jobs);
    }
}
