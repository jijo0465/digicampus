package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.models.Subject;
import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.models.TeacherTimeTable;
import com.monkmind.digicampus.services.GradeService;
import com.monkmind.digicampus.services.PeriodService;
import com.monkmind.digicampus.services.SubjectService;
import com.monkmind.digicampus.services.TeacherService;
import com.monkmind.digicampus.services.TeacherTimeTableService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TeacherTimeTableController {
	private final TeacherTimeTableService teachertimetableService;
	private final TeacherService teacherservice;
	private final PeriodService periodservice;
	private final SubjectService subjectservice;
	private final GradeService gradeservice;

	@RequestMapping("/timetableform")
	public String TeacherTimeTableForm(Model model) {
		model.addAttribute("teachertimetable", new TeacherTimeTable());
		List<Teacher> teachers=teacherservice.findAll();
		model.addAttribute("teachers",teachers);
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

	@ResponseBody
	@RequestMapping("/teachertime/{teacherId}")
	public Object getTeacherTimeTable(@PathVariable(value = "teacherId") String teacherId) {
		//Long id=(long) 13;
		Teacher savedteacher=teacherservice.getTeacherByTeacherId(teacherId);
		List<TeacherTimeTable> timetable=teachertimetableService.getByTeacherId(savedteacher);
		for (TeacherTimeTable teacherTimeTable : timetable) {
			System.out.println(teacherTimeTable.getDay());
			List<Period> periods=periodservice.getByTeacherTimeTable(teacherTimeTable);
			for (Period period : periods) {
				System.out.println(period.getStartngTime());
				Grade savedgrade=period.getStudentTimeTable().getGrade();
				Long id=savedgrade.getId();
				System.out.println(gradeservice.getGradeById(id).getStandard());
				List<Subject> subjects=subjectservice.getByPeriodId(period);
				for (Subject subject : subjects) {
					System.out.println(subject.getName());
				}
			}
		}
		return timetable;
	}

}
