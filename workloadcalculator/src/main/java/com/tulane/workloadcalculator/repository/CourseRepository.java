package com.tulane.workloadcalculator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tulane.workloadcalculator.model.Course;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Integer>{

	List<Course>findAllByCourseName(String courseName);
	
	@Query(value = "SELECT * FROM course WHERE (course_name || ' ' || professor_name || ' ' || semester || ' ' || 'degree') ILIKE CONCAT('%', ?1, '%') ORDER BY course_name", nativeQuery = true)
	List<Course> search(String keyword);
	
	Course findAllById(Integer id);
		
	
}
