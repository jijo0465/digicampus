package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.models.NonTStaffAttendance;
//import com.monkmind.digicampus.models.Student;

public interface NonTStaffAttendanceService {
	public NonTStaffAttendance save(NonTStaffAttendance nontstaffattendance);
	public NonTStaffAttendance getId(Long id);
	
	public List<NonTStaffAttendance> listAll(); 
	public void delete(long id);
	

}
