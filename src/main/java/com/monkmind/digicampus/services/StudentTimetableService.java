package com.monkmind.digicampus.services;


import java.util.List;

import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.command.StudentTimeTableCommand;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.models.SubjectSchema;

public interface StudentTimetableService {
	

	 public StudentTimeTable getById(Long id);
	 public StudentTimeTable save(StudentTimeTable studentTimetable);
	 public List<StudentTimeTable> findAll();
	 public void delete(long id);
	 StudentTimeTableCommand saveStudentTimeTableCommand(StudentTimeTableCommand command);
	 public StudentTimeTable findBySchemaId(SubjectSchema id);
	
}
