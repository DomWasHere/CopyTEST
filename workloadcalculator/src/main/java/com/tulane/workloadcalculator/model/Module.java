package com.tulane.workloadcalculator.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private Course course;
	
	private Integer moduleNumber;
	private long aboutPages;
	private long introductionText;
	private long video;
	private long podcast;
	private long discussionText;
	private long discussionVideo;
	private long meetings;
	private long meetingsLength;
	private long lectureText;
	private long lectureVideo;
	private long readingArticles;
	private long paperbackBook;
	private long academicMonograph;
	private long textbookReadings;
	private long reflectionNarrative;
	private long argument;
	private long research;
	private long caseStudy;
	private long practiceActivities;
	private long projects;
	private long studyHours;
	private long quizQuestions;
	private long practiceQuestions;
}
