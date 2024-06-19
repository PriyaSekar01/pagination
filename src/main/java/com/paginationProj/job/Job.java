package com.paginationProj.job;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title")
	private String jobTitle;

	@Column(name = "description")
	private String description;

	@Column(name = "company")
	private String company;
	
	@Column(name = "salary")
    private Double salary;

}
