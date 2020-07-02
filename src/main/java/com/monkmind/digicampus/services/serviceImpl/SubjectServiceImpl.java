package com.monkmind.digicampus.services.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.models.Subject;
import com.monkmind.digicampus.repositories.SubjectRepository;
import com.monkmind.digicampus.services.SubjectService;

import lombok.AllArgsConstructor;

//Anand A B 18/05/2020


@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService{
	private final SubjectRepository subjectrepository;
	
	
	public Subject save(Subject subject) {
		return subjectrepository.save(subject);
	}


	@Override
	public Subject getById(Long subject) {
		// TODO Auto-generated method stub
		return subjectrepository.findById(subject).get();
	}


	@Override
	public List<Subject> getByPeriodId(Period period) {
		// TODO Auto-generated method stub
		return subjectrepository.findByPeriod(period);
	}
	@Override
	public Iterable<Subject> findall(){
		return subjectrepository.findAll();
	}


}
