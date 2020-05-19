package com.monkmind.digicampus.services;

import org.springframework.stereotype.Service;


import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.repositories.StudentTimetableRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentTimetableServiceImpl implements StudentTimetableService{
	private final StudentTimetableRepository studenttimetableRepository;

	@Override
	public StudentTimeTable getById(Long id) {
		// TODO Auto-generated method stub
		return studenttimetableRepository.findById(id).get();
	}

	@Override
	public void save(StudentTimeTable studentTimeTable) {
		// TODO Auto-generated method stub
		studenttimetableRepository.save(studentTimeTable);
	}
	
	
	
	

}
