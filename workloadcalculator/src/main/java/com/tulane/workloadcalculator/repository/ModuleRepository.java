package com.tulane.workloadcalculator.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tulane.workloadcalculator.model.Course;
import com.tulane.workloadcalculator.model.Module;

public interface ModuleRepository extends PagingAndSortingRepository<Module, Integer>{

	List<Module>findAllByCourse(Course course);

	Module findAllById(Integer moduleId);
}
