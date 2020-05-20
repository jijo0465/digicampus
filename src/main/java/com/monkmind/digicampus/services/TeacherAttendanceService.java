package com.monkmind.digicampus.services;
import com.monkmind.digicampus.models.TeacherAttendance;
//haritha
//date:18/05/2020
public interface TeacherAttendanceService {
	public  TeacherAttendance getId(String id);
	public TeacherAttendance save(TeacherAttendance teacherAttendance);
}