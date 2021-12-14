package com.tulane.workloadcalculator.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Data
@Entity
@Table
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="course_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Course course;
	


	private Integer moduleNumber;
	
	@NotNull(message = "Input must not be empty")
	@Min(value=0, message="Input must be a positive number")
	private float aboutPages;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private float introductionText;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double video;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double podcast;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double discussionText;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double discussionVideo;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double meetings;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double meetingsLength;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double lectureText;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double lectureVideo;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double readingArticles;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double paperbackBook;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double academicMonograph;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double textbookReadings;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double reflectionNarrative;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double argument;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double research;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double caseStudy;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double practiceActivities;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double projects;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double studyHours;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double quizQuestions;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private double practiceQuestions;
}
