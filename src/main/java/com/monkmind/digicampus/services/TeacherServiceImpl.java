package com.monkmind.digicampus.services;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.Teacher;
//import com.monkmind.digicampus.repositories.ParentRepository;
//import com.monkmind.digicampus.repositories.StudentRepository;
import com.monkmind.digicampus.repositories.TeacherRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService{
	private final TeacherRepository teacherRepository;

	@Override
	public Teacher getTeacherByTeacherId(String teacher) {
		// TODO Auto-generated method stub
		return teacherRepository.findByTeacherId(teacher).orElse(null);
	}
	public void save(Teacher teacher) {
		teacherRepository.save(teacher);
	}
	@Override
	public Teacher getById(Long teacher) {
		// TODO Auto-generated method stub
		return teacherRepository.findById(teacher).get();
	}

}
