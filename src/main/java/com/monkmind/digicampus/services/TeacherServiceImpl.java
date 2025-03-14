package com.monkmind.digicampus.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.command.TeacherRegisterCommand;
import com.monkmind.digicampus.converters.TeacherRegisterCommandToTeacher;
import com.monkmind.digicampus.converters.TeacherToTeacherRegisterCommand;
import com.monkmind.digicampus.models.Teacher;
//import com.monkmind.digicampus.repositories.ParentRepository;
//import com.monkmind.digicampus.repositories.StudentRepository;
import com.monkmind.digicampus.repositories.TeacherRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService{
	private final TeacherRepository teacherRepository;
	private final TeacherRegisterCommandToTeacher teacherRegisterCommandToTeacher;
	private final TeacherToTeacherRegisterCommand teacherToTeacherRegisterCommand;

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
	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll();
	}
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		teacherRepository.deleteById(id);
	}
	
	@Override
	@Transactional
	public TeacherRegisterCommand saveTeacherRegisterCommand(TeacherRegisterCommand teachercommand) {
		// TODO Auto-generated method stub
		Teacher detachedTeacher=teacherRegisterCommandToTeacher.convert(teachercommand);
		Teacher savedTeacher=teacherRepository.save(detachedTeacher);
		return teacherToTeacherRegisterCommand.convert(savedTeacher) ;
	}

}
