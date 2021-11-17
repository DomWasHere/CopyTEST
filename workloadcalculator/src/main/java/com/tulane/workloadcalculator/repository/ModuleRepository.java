package com.tulane.workloadcalculator.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tulane.workloadcalculator.model.Module;

public interface ModuleRepository extends PagingAndSortingRepository<Module, Integer>{

}
