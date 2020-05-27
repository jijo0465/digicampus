package com.monkmind.digicampus.services;
import java.util.List;

import com.monkmind.digicampus.models.StudentAttendance;
//haritha
//date:18/05/2020
public interface StudentAttendanceService {
	public  StudentAttendance getId(String id);
	public StudentAttendance save(StudentAttendance studentAttendance);
	public List<StudentAttendance> listAll();
	public void delete(Long id);
}