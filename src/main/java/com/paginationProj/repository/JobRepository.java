package com.paginationProj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paginationProj.job.Job;


@Repository
public interface JobRepository extends JpaRepository<Job, Long>{

}
