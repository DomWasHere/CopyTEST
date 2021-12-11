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
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Positive;
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
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long aboutPages;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long introductionText;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long video;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long podcast;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long discussionText;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long discussionVideo;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long meetings;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long meetingsLength;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long lectureText;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long lectureVideo;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long readingArticles;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long paperbackBook;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long academicMonograph;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long textbookReadings;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long reflectionNarrative;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long argument;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long research;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long caseStudy;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long practiceActivities;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long projects;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long studyHours;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long quizQuestions;
	
	@NotNull(message = "Input must be a positive number")
	@Min(value=0, message="Input must be a positive number")
	private long practiceQuestions;
}
