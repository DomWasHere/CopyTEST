package com.tulane.workloadcalculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulane.workloadcalculator.repository.ModuleRepository;
import com.tulane.workloadcalculator.model.Course;
import com.tulane.workloadcalculator.model.Module;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;
	
	public void save(Module module) {
		moduleRepository.save(module);
		
	}
	public List<Module>findAllByCourse(Course course){
		List<Module> modules =  moduleRepository.findAllByCourse(course);
		return modules;
	}
	public Module findAllById(Integer moduleId) {
		return moduleRepository.findAllById(moduleId);
		
	}
	
}
