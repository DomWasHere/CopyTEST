package com.tulane.workloadcalculator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		List<Course> searchResult = courseService.findAll();
		model.addAttribute("searchResult", searchResult);
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
		List<Module> modules = moduleService.findAllByCourse(course);
		model.addAttribute("modules", modules);
		return "newModule";
		
	}
	
	@PostMapping(value= {"/courses/{course.id}"})
	public String submitModuleForm(@PathVariable(value = "course.id")Integer id, Model model, Module module) {
		Course course = courseService.findAllById(id);
		model.addAttribute("course", course);
		course.setId(id);
		model.addAttribute("module", module);
		moduleService.save(module);
		
		model.addAttribute("successMessage", "Module successfully saved!");
		List<Module> modules = moduleService.findAllByCourse(course);
		model.addAttribute("modules", modules);
		return "newModule";
	}
	
	@GetMapping(value= {"/courses/{course.id}/modules/{module.id}"})
	public String getModuleForm(@PathVariable(value= "course.id")Integer id, Model model, @PathVariable(value = "module.id")Integer moduleId) {
		Module module = moduleService.findAllById(moduleId);
		module.setId(moduleId);
		model.addAttribute("module", module);
		Course course = courseService.findAllById(id);
		model.addAttribute("course", course);
		List<Module> modules = moduleService.findAllByCourse(course);
		model.addAttribute("modules", modules);
		
		return "Module";
	}
	@PostMapping(value= {"/courses/{course.id}/modules/{module.id}"})
	public String submitModuleForm(@PathVariable(value = "course.id")Integer id, Module module, Model model, @PathVariable(value="module.id")Integer moduleId, HttpServletRequest req) {
		Course course = courseService.findAllById(id);
		model.addAttribute("course", course);
			
		
		module = moduleService.findAllById(moduleId);
			
		module.setCourse(course);
		module.setId(moduleId);
		module.setModuleNumber(module.getModuleNumber());
		module.setAboutPages(Integer.parseInt(req.getParameter("aboutPages")));
		module.setIntroductionText(Integer.parseInt(req.getParameter("introductionText")));
		module.setVideo(Integer.parseInt(req.getParameter("video")));
		module.setPodcast(Integer.parseInt(req.getParameter("podcast")));
		module.setDiscussionText(Integer.parseInt(req.getParameter("discussionText")));
		module.setDiscussionVideo(Integer.parseInt(req.getParameter("discussionVideo")));
		module.setMeetings(Integer.parseInt(req.getParameter("meetings")));
		module.setMeetingsLength(Integer.parseInt(req.getParameter("meetingsLength")));
		module.setLectureText(Integer.parseInt(req.getParameter("lectureText")));
		module.setLectureVideo(Integer.parseInt(req.getParameter("lectureVideo")));
		module.setReadingArticles(Integer.parseInt(req.getParameter("readingArticles")));
		module.setPaperbackBook(Integer.parseInt(req.getParameter("paperbackBook")));
		module.setAcademicMonograph(Integer.parseInt(req.getParameter("academicMonograph")));
		module.setTextbookReadings(Integer.parseInt(req.getParameter("textbookReadings")));
		module.setReflectionNarrative(Integer.parseInt(req.getParameter("reflectionNarrative")));
		module.setArgument(Integer.parseInt(req.getParameter("argument")));
		module.setResearch(Integer.parseInt(req.getParameter("research")));
		module.setCaseStudy(Integer.parseInt(req.getParameter("caseStudy")));
		module.setPracticeActivities(Integer.parseInt(req.getParameter("practiceActivities")));
		module.setProjects(Integer.parseInt(req.getParameter("projects")));
		module.setStudyHours(Integer.parseInt(req.getParameter("studyHours")));
		module.setQuizQuestions(Integer.parseInt(req.getParameter("quizQuestions")));
		module.setPracticeQuestions(Integer.parseInt(req.getParameter("practiceQuestions")));
		List<Module> modules = moduleService.findAllByCourse(course);
		model.addAttribute("modules", modules);
		model.addAttribute("module", module);
		
			
		moduleService.save(module);
		model.addAttribute("successMessage", "Module successfully saved!");
			
			
		return "Module";
	}
	
	@GetMapping(value= {"/edit/courses/{course.id}"})
	public String getEditCourseForm(@PathVariable(value = "course.id")Integer id, Model model) {
		Course course = courseService.findAllById(id);
		course.setId(id);
		model.addAttribute("course", course);
		
		
		return "editCourse";
	}
	
	@PostMapping(value = {"/edit/courses/{course.id}"})
	public String submitEditCourseForm(@PathVariable(value = "course.id")Integer id, Model model, HttpServletRequest req) {
		
		Course course = courseService.findAllById(id);
		course.setId(id);
		model.addAttribute("course", course);
		course.setSemester(req.getParameter("semester"));
		course.setSemesterYear(Integer.parseInt(req.getParameter("semesterYear")));
		course.setCourseURL(req.getParameter("courseURL"));
		course.setCourseNumber(req.getParameter("courseNumber"));
		course.setCourseName(req.getParameter("courseName"));
		course.setProfessorName(req.getParameter("professorName"));
		courseService.save(course);
		
		return "editCourse";
	}
}
