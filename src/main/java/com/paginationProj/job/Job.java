package com.paginationProj.job;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private int salary;
	
	 public Job(String jobTitle, String description, String company, int salary) {
	        this.jobTitle = jobTitle;
	        this.description = description;
	        this.company = company;
	        this.salary = salary;
	    }

}
