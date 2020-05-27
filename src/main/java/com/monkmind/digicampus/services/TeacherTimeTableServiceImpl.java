package com.monkmind.digicampus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.TeacherTimeTable;
import com.monkmind.digicampus.repositories.TeacherTimeTableRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherTimeTableServiceImpl implements TeacherTimeTableService {
private final TeacherTimeTableRepository teachertimetableRepository;
	@Override
	public TeacherTimeTable getById(Long id) {
		// TODO Auto-generated method stub
		return teachertimetableRepository.findById(id).get() ;
	}

	@Override
	public TeacherTimeTable save(TeacherTimeTable teachertimetable) {
		// TODO Auto-generated method stub
		return teachertimetableRepository.save(teachertimetable);
	}

	@Override
	public List<TeacherTimeTable> findAll() {
		// TODO Auto-generated method stub
		return teachertimetableRepository.findAll();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		teachertimetableRepository.deleteById(id);
	}

}
