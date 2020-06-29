package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.models.Subject;

//Anand A B 18/05/2020



public interface SubjectService {
	
	public Subject save(Subject subject);
	public Iterable<Subject> findall();
	public Subject getById(Long subject);
	public List<Subject> getByPeriodId(Period period);

}
