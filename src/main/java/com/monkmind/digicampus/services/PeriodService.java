package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.models.StudentTimeTable;
//Anand A B 18/05/2020

public interface PeriodService {
	public Period getByPeriodId(Long id);
	public Period save(Period period);
	public List<Period> listAll();
	public void delete(Long id);
	public List<Period> getByStudentTimeTable(StudentTimeTable studenttimetable);
}
