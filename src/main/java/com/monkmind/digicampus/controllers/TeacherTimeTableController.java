package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.models.TeacherAttendance;
import com.monkmind.digicampus.models.TeacherTimeTable;
import com.monkmind.digicampus.services.TeacherTimeTableService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TeacherTimeTableController {
	private final TeacherTimeTableService teachertimetableService;

	@RequestMapping("/timetableform")
	public String TeacherTimeTableForm(Model model) {
		model.addAttribute("teachertimetable", new TeacherTimeTable());
		return "fragments/forms/teachertimetable::teachertimetable";
	}

	@PostMapping("/teacher_timetable")
	public String createTimetable(@ModelAttribute TeacherTimeTable teachertimetable, Model model) {
		TeacherTimeTable timeTable = teachertimetableService.save(teachertimetable);
		model.addAttribute("teachertimetable", timeTable);
		return "redirect:/";
	}

	@RequestMapping("/teachertimetabledisplayform")
	public String TeacherTimeTableDisplayForm(Model model) {
		List<TeacherTimeTable> tchrtime = teachertimetableService.findAll();
		model.addAttribute("tchrtime", tchrtime);
		return "teachertimetabledisplay";
	}

	@RequestMapping("/d/{id}")
	public String timetableTeacher(@PathVariable String id, Model model) {
		System.out.println(id);
		TeacherTimeTable teacherTimetable = teachertimetableService.getById(new Long(id));
		model.addAttribute("teacherTimetable", teacherTimetable);
		return "updateteachertimetable";
	}

	@PostMapping
	@RequestMapping("/updateteachertimetable/{id}")
	public String InsertTeachertimetable(@ModelAttribute TeacherTimeTable teacherTimetable, Model model) {
		teachertimetableService.save(teacherTimetable);
		return "index";
	}

	@RequestMapping("/tchrtime/{id}")
	public String deleteParent(@PathVariable Long id, Model model) {
		teachertimetableService.delete(id);
		return "redirect:/";

	}

}
