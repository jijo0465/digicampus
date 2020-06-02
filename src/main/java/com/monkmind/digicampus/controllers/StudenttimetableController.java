/*created by:shijina
  created on:19/5/2020
    */
package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.services.StudentTimetableService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class StudenttimetableController {
	
	private final StudentTimetableService studentTimetableService;
	
	 @RequestMapping("/studenttimetableform")
	public String timetableForm(Model model) {
	    model.addAttribute("studentTimetable", new StudentTimeTable());
	    return "studenttimetable_form";
	}

	@PostMapping
	@RequestMapping("/timetableinsert")
	public String createTimeTable(@ModelAttribute StudentTimeTable studentTimetable,Model model) {
	    StudentTimeTable timetable=studentTimetableService.save(studentTimetable);
	    model.addAttribute("studentTimetable",timetable);
	    return "index";
	}
	
	
	 @RequestMapping("/studenttimetableformdisplay")
		public String timetableDisplay(Model model) {
		 List<StudentTimeTable> timetables=studentTimetableService.findAll();
		    model.addAttribute("timetables",timetables);
		    return "studenttimetabledisplay";
		}
	@RequestMapping("/e/{id}")
	public String timetableEdit(@PathVariable String id,Model model) {
		System.out.println(id);
	    StudentTimeTable studentTimetable = studentTimetableService.getById(new Long(id));
	    model.addAttribute("studentTimetable",studentTimetable);
	     return "updatestudenttimetable";
	}
	
	@PostMapping
	@RequestMapping("/updatetimetable/{id}")
	public String InsertTimetable(@ModelAttribute StudentTimeTable studentTimetable,Model model) {
		studentTimetableService.save(studentTimetable);
	    return "index";
	}

	@RequestMapping("/timedele/{id}")
	public String deleteStudentTimetable(@PathVariable Long id,Model model)
	{
		studentTimetableService.delete(id);
		return "redirect:/";
		
	}
}
