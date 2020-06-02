package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.models.NonTeachingStaff;
/*Anand A B 18/05/2020*/


public interface NonTeachinService {
	public NonTeachingStaff getById(long id);
	public NonTeachingStaff save(NonTeachingStaff nonteachingstaff);
	//public List< NonTeachingStaff> findAll();
	public List<NonTeachingStaff> listAll();
	public void delete(long id);

}
