package com.tulane.workloadcalculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tulane.workloadcalculator.model.Course;
import com.tulane.workloadcalculator.model.Module;
import com.tulane.workloadcalculator.service.CourseService;
import com.tulane.workloadcalculator.service.ModuleService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ModuleService moduleService;
	
	@GetMapping(value= {"/home", "/"})
	public String getHome() {
		return "Home";
	}
	
	@GetMapping(value= {"/courses/search"})
	public String getSearch(@Param("keyword") String keyword, Model model) {
		return "Search";
	}
	
	@GetMapping(value= {"/search"})
	public String search(@Param("keyword") String keyword, Model model) {
		List<Course> searchResult = courseService.search(keyword);
		
		model.addAttribute("searchResult", searchResult);
		
		return "Search";
	}
	
	@GetMapping(value= {"/courses/new"})
	public String getCourseForm(Model model) {
		model.addAttribute("course", new Course());
		return "Course";
	}
	
	@PostMapping(value="/courses")
	public String submitCourseForm(Course course, Model model) {
		courseService.save(course);
		model.addAttribute("successMessage", "Course successfully created!");
		return "Course";
	}
	
	@GetMapping(value= {"/courses/{course.id}"})
	public String getModuleForm(@PathVariable(value = "course.id")Integer id,Model model) {
		model.addAttribute("module", new Module());
		Course course = courseService.findAllById(id);
		model.addAttribute("course", course);
		return "Module";
	}
	
	@PostMapping(value= {"/courses/{course.id}"})
	public String submitModuleForm(@PathVariable(value = "course.id")Integer id, Module module, Model model) {
		Course course = courseService.findAllById(id);
		model.addAttribute("course", course);
		course.setId(id);
		module.setCourse(course);
		moduleService.save(module);
		model.addAttribute("successMessage", "Module successfully saved!");
		return "Module";
	} 
}
