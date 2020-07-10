package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.command.NonTeachingStaffCommand;
import com.monkmind.digicampus.models.NonTeachingStaff;
/*Anand A B 18/05/2020*/
import com.monkmind.digicampus.models.Student;


public interface NonTeachinService {
	public NonTeachingStaff getById(long id);
	public NonTeachingStaff save(NonTeachingStaff nonteachingstaff);
	public NonTeachingStaff findById(long id);
	//public List< NonTeachingStaff> findAll();
	public List<NonTeachingStaff> listAll();
	public void delete(long id);
     NonTeachingStaffCommand saveNonTeachingStaffCommand(NonTeachingStaffCommand staffcommand);
     public NonTeachingStaff getNonTeachingStaffByStaffId(String staffid);
	//public NonTeachingStaff getByStaffId(Long long1);
     public List<NonTeachingStaff> listAll(String keyword);
}
