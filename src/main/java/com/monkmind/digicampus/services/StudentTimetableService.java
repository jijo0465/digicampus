package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.SchoolBus;
import com.monkmind.digicampus.models.StudentTimeTable;

public interface StudentTimetableService {
	

	public StudentTimeTable getById(Long id);
	 public void save(StudentTimeTable studentTimeTable);

}
