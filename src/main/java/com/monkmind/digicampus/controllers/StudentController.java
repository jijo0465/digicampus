package com.monkmind.digicampus.controllers;


import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.services.GradeService;
import com.monkmind.digicampus.services.ParentService;
import com.monkmind.digicampus.services.StudentService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@Controller
public class StudentController {
    private final StudentService studentService;
    private final GradeService gradeService;
    private final ParentService parentService;

    /*author:shijina
    created date:15/5/2020
    */

    @RequestMapping("/add_student")
    public String studentForm(Model model) {
        RegisterCommand registerCommand = new RegisterCommand();
        List<Grade> gradeCommands = gradeService.listAll();
        model.addAttribute("command", registerCommand);
        model.addAttribute("gradeList", gradeCommands);
        return "fragments/dc-components/dc-screen-layout/dc-student-add.html::dc-student-add";
    }

    @PostMapping
    @RequestMapping("/addstudent")
    public String Save(@ModelAttribute RegisterCommand command, Model model) {
        long parentid = (long) Math.floor(Math.random() * 9000000L) + 100000L;
        command.getParentid().setParentId(Long.toString(parentid));
        studentService.saveRegisterCommand(command);
        return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
    }
   

    @RequestMapping("/studentdisplay")
    public String studentdisplay(Model model) {
        List<Student> liststudents = studentService.listAll();
        List<Grade> gradeCommands = gradeService.listAll();
        model.addAttribute("gradeList", gradeCommands);
        model.addAttribute("liststudents", liststudents);
        return "fragments/dc-components/dc-screen-layout/dc-student-display.html::dc-student-display";
    }

    @RequestMapping("/displaystd/{std}")
    public String viewclasswise(@PathVariable Grade std, Model model) {
        System.out.println(std);
        List<Student> students = studentService.findByGradeid(std);
        model.addAttribute("students", students);
        return "fragments/dc-components/dc-screen-layout/dc-student-list.html::dc-student-list";
    }

    @RequestMapping("/edit/student")
    public String getEditStudentForm(Model model) {
        return "fragments/dc-components/dc-screen-layout/dc-student-edit::dc-student-edit";
    }

    @RequestMapping("/edit/student/{studentid}")
    public String studentUpdate(@PathVariable String studentid, Model model) {
        //ModelAndView mav = new ModelAndView("edit_product");
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
        return "fragments/dc-components/dc-screen-layout/dc-student-edit-02.html::dc-student-edit-02";
    }

    /*
    @PostMapping
    @RequestMapping("/addstudent")
    public String Save(@ModelAttribute RegisterCommand command, Model model) {
        long parentid = (long) Math.floor(Math.random() * 9000000L) + 100000L;
        command.getParentid().setParentId(Long.toString(parentid));
        studentService.saveRegisterCommand(command);
        return "fragments/forms/confirmpage::confirmpage";
    }*/
    @PostMapping
    @RequestMapping("updatestudent")
    public String UpdateStudent(@ModelAttribute Student studentbyid, Model model) {
        // Student savedCommand=studentService.(command);
        studentService.save(studentbyid);

        // System.out.println(savedCommand.getDateOfBirth());
        return "fragments/dc-components/dc-screen-layout/dc-student-confirm.html::dc-student-confirm";
    }

    @ResponseBody
    @RequestMapping("/validateStudentId/{studentId}")
    public String InsertStudent(@PathVariable String studentId, Model model) {
        System.out.println(studentId);
        Student s = studentService.getStudentByStudentId(studentId);
        if (s != null) {
            return "exists";
        } else {
            return "notExists";
        }
    }


    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model) {
        studentService.delete(id);
        return "mydashboard";

    }

    @RequestMapping("/studentUpdate/{studentId}")
    public String updatestudent(@PathVariable String studentId, Model model) {
        Student student = studentService.getStudentByStudentId(studentId);
        if (student != null) {
            model.addAttribute("response", "exists");
            model.addAttribute("student", student);

        } else {
            model.addAttribute("response", "failed");
        }
        return "fragments/forms/editstud::editstud";
    }

    @RequestMapping("/studentupdate")
    public String updatestudent(Model model) {
        List<Grade> gradeCommands = gradeService.listAll();
        model.addAttribute("gradeList", gradeCommands);
        return "fragments/edit/studentedit::studentedit";
    }
    
    @RequestMapping("/searchstudent")
    public String searchstudent(@Param("keyword") String keyword,Model model )
    {
       List<Student> liststudents = studentService.listAll(keyword);
            model.addAttribute("liststudents", liststudents);
            //model.addAttribute("keyword", keyword);
    	return "fragments/dc-components/dc-screen-layout/dc-student-search.html::dc-student-search";
    }


}
