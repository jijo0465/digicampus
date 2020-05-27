package com.monkmind.digicampus.services;
import java.util.List;

import com.monkmind.digicampus.models.TeacherAttendance;
//haritha
//date:18/05/2020
public interface TeacherAttendanceService {
	public  TeacherAttendance getId(Long id);
	public TeacherAttendance save(TeacherAttendance teacherAttendance);
	public List<TeacherAttendance> listAll();
	public void delete(Long id);
}