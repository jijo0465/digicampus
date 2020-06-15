package com.monkmind.digicampus.command.teacher_app;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Subject;
import com.monkmind.digicampus.models.TeacherAttendance;
import com.monkmind.digicampus.models.TeacherTimeTable;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

public class TeacherCommand {

    private String teacherId;
    private String name;
    private String password;
    private Set<Subject> subjects = new HashSet<>();
    private TeacherTimeTable teacherTimeTable;
}
