package com.tulane.workloadcalculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulane.workloadcalculator.model.Course;
import com.tulane.workloadcalculator.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> findAll(){
		return (List<Course>) courseRepository.findAll();
	}
	
	public List<Course>findAllByCourseName(String courseName){
		List<Course>courses = courseRepository.findAllByCourseName(courseName);
		return courses;
	}
	
	public void save(Course course) {
		courseRepository.save(course);
	}
	
	public List<Course> search(String keyword){
		return courseRepository.search(keyword);
	}
	
	public Course findAllById(Integer id){
		return courseRepository.findAllById(id);
	}
}
