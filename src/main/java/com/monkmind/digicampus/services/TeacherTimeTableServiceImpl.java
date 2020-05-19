package com.monkmind.digicampus.services;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.TeacherTimeTable;
import com.monkmind.digicampus.repositories.TeacherTimeTableRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherTimeTableServiceImpl implements TeacherTimeTableService {
private final TeacherTimeTableRepository teachertimetableRepository;
	@Override
	public TeacherTimeTable getById(String teachertimetable) {
		// TODO Auto-generated method stub
		return teachertimetableRepository.findById(teachertimetable).get() ;
	}

	@Override
	public void save(TeacherTimeTable teachertimetable) {
		// TODO Auto-generated method stub
		teachertimetableRepository.save(teachertimetable);
	}

}
