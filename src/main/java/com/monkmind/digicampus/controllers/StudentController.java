package com.monkmind.digicampus.controllers;


import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.SubjectSchema;
import com.monkmind.digicampus.services.GradeService;
import com.monkmind.digicampus.services.ParentService;
import com.monkmind.digicampus.services.StudentService;
import com.monkmind.digicampus.services.SubjectSchemaService;

import lombok.AllArgsConstructor;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@AllArgsConstructor
@Controller
public class StudentController {
    private final StudentService studentService;
    private final GradeService gradeService;
    private final ParentService parentService;
    private final SubjectSchemaService subjectSchemaService;

    /*author:shijina
    created date:15/5/2020
    */

    @GetMapping("/add_student")
    public String studentForm(Model model) {
        model.addAttribute("command", new RegisterCommand());
        model.addAttribute("gradeList", gradeService.listAll());
        model.addAttribute("schemaList", subjectSchemaService.listAll());
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-add.html::dc-student-add";
    }

    @PostMapping(path="/addstudent")
    public String Save(@ModelAttribute RegisterCommand command, Model model) {
        studentService.saveRegisterCommand(command);
        return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
    }
   

    @GetMapping("/studentdisplay")
    public String studentdisplay(Model model) {
        model.addAttribute("gradeList", gradeService.listAll());
        model.addAttribute("liststudents", studentService.listAll());
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-display.html::dc-student-display";
    }

    @GetMapping("/displaystd/{std}")
    public String viewclasswise(@PathVariable Grade std, Model model) {
        model.addAttribute("students", studentService.findByGradeid(std));
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-list.html::dc-student-list";
    }

    @GetMapping("/edit/student")
    public String getEditStudentForm(Model model) {
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-edit::dc-student-edit";
    }

    @GetMapping("/edit/student/{studentId}")
    public String studentUpdate(@PathVariable String studentId, Model model) {
        model.addAttribute("command", new RegisterCommand());
        model.addAttribute("gradeList", gradeService.listAll());
        model.addAttribute("studentbyid", studentService.getStudentByStudentId(studentId));
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-edit-02.html::dc-student-edit-02";
    }

    @PostMapping(path="/updatestudent")
    public String UpdateStudent(@ModelAttribute RegisterCommand command, Model model) {
        studentService.updateRegisterCommand(command);
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-edit-confirm.html::dc-student-edit-confirm";
    }

    @ResponseBody
    @GetMapping("/validateStudentId/{studentId}")
    public String InsertStudent(@PathVariable String studentId, Model model) {
        Student s = studentService.getStudentByStudentId(studentId);
        if (s != null) {
            return "exists";
        } else {
            return "notExists";
        }
    }


    @GetMapping("student/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model) {
        studentService.isDelete(id);
        return "redirect:/mydashboard";

    }

    @GetMapping("/searchstudent")
    public String searchstudent(Model model)
    {
        model.addAttribute("students",studentService.listAll());
    	return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-search.html::dc-student-search";
    }
    @GetMapping("/student/search/{keyword}")
    public String studentsearch(@PathVariable String keyword,Model model)
    {
        model.addAttribute("students", studentService.listAll(keyword));
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-list.html::dc-student-list";
    }
    @PostMapping("/student/profile/{id}")
    public String studentProfile(@PathVariable Long id,Model model){
        model.addAttribute("student",studentService.findById(id));
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-profile::dc-student-profile";
    }

}
