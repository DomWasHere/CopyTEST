package com.tulane.workloadcalculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tulane.workloadcalculator.repository.ModuleRepository;
import com.tulane.workloadcalculator.model.Module;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;
	
	public void save(Module module) {
		moduleRepository.save(module);
		
	}
}
