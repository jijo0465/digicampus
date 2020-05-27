package com.monkmind.digicampus.services;

import java.util.List;

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
	public StudentTimeTable  save(StudentTimeTable studentTimetable) {
		// TODO Auto-generated method stub
		 return studenttimetableRepository.save(studentTimetable);
	}

	@Override
	public StudentTimeTable getByDay(Long day) {
		// TODO Auto-generated method stub
		return studenttimetableRepository.findByDay(day).get();
	}

	@Override
	public List<StudentTimeTable> findAll() {
		// TODO Auto-generated method stub
		return studenttimetableRepository.findAll();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		studenttimetableRepository.deleteById(id);
	}

	
	
	
	

	
	
	
	
	

}
