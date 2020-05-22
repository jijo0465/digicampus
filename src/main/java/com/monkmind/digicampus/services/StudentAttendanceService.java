package com.monkmind.digicampus.services;
import com.monkmind.digicampus.models.StudentAttendance;
//haritha
//date:18/05/2020
public interface StudentAttendanceService {
	public  StudentAttendance getId(Long id);
	public StudentAttendance save(StudentAttendance studentAttendance);
}