package com.monkmind.digicampus.services;
import com.monkmind.digicampus.models.TeacherTimeTable;
//haritha
//19/20/2020
public interface TeacherTimeTableService {
	
	public TeacherTimeTable getById(Long id);
	public TeacherTimeTable save(TeacherTimeTable teachertimetable);
}
