package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.NonTeachingStaff;
/*Anand A B 18/05/2020*/


public interface NonTeachinService {
	public NonTeachingStaff getById(String id);
	public NonTeachingStaff save(NonTeachingStaff nonteachingstaff);

}
