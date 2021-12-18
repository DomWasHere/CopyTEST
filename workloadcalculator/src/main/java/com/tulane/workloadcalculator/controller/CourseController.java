package com.tulane.workloadcalculator.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	/*@GetMapping(value={"/moreinfo"})
	public String getMoreInfo() {
		return "SoPAWorkLoadCalculatorOverview.pdf";
	}*/
	
	/*@GetMapping(value = "/moreinfo")
    public void showPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        //response.setHeader("Content-Disposition", "attachment; filename=\"demo.pdf\"");
        InputStream inputStream = new FileInputStream(new File("../SoPAWorkloadCalculatorOverview.pdf"));
        int nRead;
        while ((nRead = inputStream.read()) != -1) {
            response.getWriter().write(nRead);
        }
    } */
	
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
		return "Search";
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
	public String submitModuleForm(@PathVariable(value = "course.id")Integer id,@Valid Module module, BindingResult bindingResult, Model model, @PathVariable(value="module.id")Integer moduleId, HttpServletRequest req) {
		Course course = courseService.findAllById(id);
		model.addAttribute("course", course);
		
		
		module = moduleService.findAllById(moduleId);
		
		
		if(!bindingResult.hasErrors()) {
		module.setCourse(course);
		module.setId(moduleId);
		module.setModuleNumber(module.getModuleNumber());
		module.setAboutPages(Float.parseFloat(req.getParameter("aboutPages")));
		module.setIntroductionText(Float.parseFloat(req.getParameter("introductionText")));
		module.setVideo(Double.parseDouble(req.getParameter("video")));
		module.setPodcast(Double.parseDouble(req.getParameter("podcast")));
		module.setDiscussionText(Double.parseDouble(req.getParameter("discussionText")));
		module.setDiscussionVideo(Double.parseDouble(req.getParameter("discussionVideo")));
		module.setMeetings(Double.parseDouble(req.getParameter("meetings")));
		module.setMeetingsLength(Double.parseDouble(req.getParameter("meetingsLength")));
		module.setLectureText(Double.parseDouble(req.getParameter("lectureText")));
		module.setLectureVideo(Double.parseDouble(req.getParameter("lectureVideo")));
		module.setReadingArticles(Double.parseDouble(req.getParameter("readingArticles")));
		module.setPaperbackBook(Double.parseDouble(req.getParameter("paperbackBook")));
		module.setAcademicMonograph(Double.parseDouble(req.getParameter("academicMonograph")));
		module.setTextbookReadings(Double.parseDouble(req.getParameter("textbookReadings")));
		module.setReflectionNarrative(Double.parseDouble(req.getParameter("reflectionNarrative")));
		module.setArgument(Double.parseDouble(req.getParameter("argument")));
		module.setResearch(Double.parseDouble(req.getParameter("research")));
		module.setCaseStudy(Double.parseDouble(req.getParameter("caseStudy")));
		module.setPracticeActivities(Double.parseDouble(req.getParameter("practiceActivities")));
		module.setProjects(Double.parseDouble(req.getParameter("projects")));
		module.setStudyHours(Double.parseDouble(req.getParameter("studyHours")));
		module.setQuizQuestions(Double.parseDouble(req.getParameter("quizQuestions")));
		module.setPracticeQuestions(Double.parseDouble(req.getParameter("practiceQuestions")));
		List<Module> modules = moduleService.findAllByCourse(course);
		model.addAttribute("modules", modules);
		model.addAttribute("module", module);
		
			
		moduleService.save(module);
		model.addAttribute("successMessage", "Module successfully saved!");
		}
		
		moduleId = module.getId();
		model.addAttribute("module", module);
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
		course.setCourseCredits(Integer.parseInt(req.getParameter("courseCredits")));
		courseService.save(course);
		
		return "Search";
	}
}
