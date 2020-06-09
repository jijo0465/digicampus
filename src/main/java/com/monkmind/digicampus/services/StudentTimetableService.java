package com.monkmind.digicampus.services;


import java.util.List;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.StudentTimeTable;

public interface StudentTimetableService {
	

	 public StudentTimeTable getById(Long id);
	 public StudentTimeTable save(StudentTimeTable studentTimetable);
	 public StudentTimeTable getByDay(Long day);
	 public List<StudentTimeTable> findAll();
	 public void delete(long id);
	 public List<StudentTimeTable> findByGrade(Grade grade);
	
}
