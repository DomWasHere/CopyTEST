package com.tulane.workloadcalculator.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String courseNumber;
	private String courseName;
	private String professorName;
	private String semester;
	private Integer semesterYear;
	private String courseURL;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
	private List<Module> modules;
	
	private Integer courseCredits;
	
}
