package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Grade;
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
    return "teachertimetable_form";
}
@PostMapping
@RequestMapping("/teacher_timetable")
public String createTimetable(@ModelAttribute TeacherTimeTable teachertimetable ,Model model) {
    teachertimetableService.save(teachertimetable);
    return "index";


}
}
