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
        RegisterCommand registerCommand = new RegisterCommand();
        List<Grade> gradeCommands = gradeService.listAll();
        List<SubjectSchema> schema =subjectSchemaService.listAll();
        model.addAttribute("command", registerCommand);
        model.addAttribute("gradeList", gradeCommands);
        model.addAttribute("schemaList", schema);
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-add.html::dc-student-add";
    }

    @PostMapping(path="/addstudent")
    public String Save(@ModelAttribute RegisterCommand command, Model model) {
        long parentid = (long) Math.floor(Math.random() * 9000000L) + 100000L;
        command.getParentid().setParentId(Long.toString(parentid));
        studentService.saveRegisterCommand(command);
        return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
    }
   

    @GetMapping("/studentdisplay")
    public String studentdisplay(Model model) {
        List<Student> liststudents = studentService.listAll();
        List<Grade> gradeCommands = gradeService.listAll();
        model.addAttribute("gradeList", gradeCommands);
        model.addAttribute("liststudents", liststudents);
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-display.html::dc-student-display";
    }

    @GetMapping("/displaystd/{std}")
    public String viewclasswise(@PathVariable Grade std, Model model) {
        System.out.println(std);
        List<Student> students = studentService.findByGradeid(std);
        model.addAttribute("students", students);
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-list.html::dc-student-list";
    }

    @GetMapping("/edit/student")
    public String getEditStudentForm(Model model) {
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-edit::dc-student-edit";
    }

    @GetMapping("/edit/student/{studentid}")
    public String studentUpdate(@PathVariable String studentid, Model model) {
        System.out.println(studentid);
        Student registerCommand = new Student();
        model.addAttribute("command", registerCommand);
        List<Grade> gradeCommands = gradeService.listAll();
        Student student = new Student();
        student = studentService.getStudentByStudentId(studentid);
        Parent parent=new Parent();
        parent=parentService.getParentByParentId(studentid);
        model.addAttribute("gradeList", gradeCommands);
        model.addAttribute("studentbyid", student);
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-edit-02.html::dc-student-edit-02";
    }

    @PostMapping(path="/updatestudent")
    public String UpdateStudent(@ModelAttribute Student studentbyid, Model model) {
        studentService.save(studentbyid);
        return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
    }

    @ResponseBody
    @GetMapping("/validateStudentId/{studentId}")
    public String InsertStudent(@PathVariable String studentId, Model model) {
        System.out.println(studentId);
        Student s = studentService.getStudentByStudentId(studentId);
        if (s != null) {
            return "exists";
        } else {
            return "notExists";
        }
    }


    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model) {
        Student student=studentService.findById(id);
        student.setIsDelete(true);
        studentService.save(student);
        return "redirect:/mydashboard";

    }

    @GetMapping("/searchstudent")
    public String searchstudent(Model model)
    {
        List<Student> students=studentService.listAll();
        model.addAttribute("students",students);
    	return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-search.html::dc-student-search";
    }
    @GetMapping("/student/search/{keyword}")
    public String studentsearch(@PathVariable String keyword,Model model)
    {
        List<Student> liststudents = studentService.listAll(keyword);
        model.addAttribute("students", liststudents);
        return "fragments/dc-components/dc-screen-layout/dc-student/dc-student-list.html::dc-student-list";
    }

}
