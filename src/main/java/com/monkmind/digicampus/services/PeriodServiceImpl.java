package com.monkmind.digicampus.services;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.repositories.PeriodRepository;

import lombok.AllArgsConstructor;
//Anand A B 18/05/2020

@Service
@AllArgsConstructor
public class PeriodServiceImpl implements PeriodService{
	private final PeriodRepository periodrepository;
	
	public Period getByPeriodId(Long id) {
		return periodrepository.findById(id).get();
	}
	
	public void save(Period period) {
		periodrepository.save(period);
	}
	

}
