package com.monkmind.digicampus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.repositories.PeriodRepository;

import lombok.AllArgsConstructor;
//Anand A B 18/05/2020

@Service
@AllArgsConstructor
public class PeriodServiceImpl implements PeriodService{
	private final PeriodRepository periodRepository;
	
	public Period getByPeriodId(Long id) {
		return periodRepository.findById(id).get();
	}
	
	public Period save(Period period) {
		return periodRepository.save(period);
	}

	@Override
	public List<Period> listAll() {
		// TODO Auto-generated method stub
		return periodRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		periodRepository.deleteById(id);
	}

	@Override
	public List<Period> getByStudentTimeTable(StudentTimeTable studentTimeTable) {
		// TODO Auto-generated method stub
		return periodRepository.findByStudentTimeTable(studentTimeTable);
		
	}
	
	

}
