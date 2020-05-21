package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.Period;
//Anand A B 18/05/2020

public interface PeriodService {
	public Period getByPeriodId(Long id);
	public void save(Period period);

}
