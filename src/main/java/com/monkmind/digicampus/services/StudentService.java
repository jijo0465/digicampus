package com.monkmind.digicampus.services;



import java.util.List;

import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.models.Grade;
//import com.monkmind.digicampus.controllers.List;
import com.monkmind.digicampus.models.Student;

import javax.transaction.Transactional;

public interface StudentService{
	public Student getStudentByStudentId(String student);
	public void save(Student student);
	public List<Student> listAll();
	public void delete(long id);
	Student findById(long l);
	public void isDelete(Long id);
	@Transactional
	RegisterCommand updateRegisterCommand(RegisterCommand command);

	RegisterCommand findCommandById(long l);

	RegisterCommand saveRegisterCommand(RegisterCommand command);
	public List<Student> findByGradeid(Grade std);
	public RegisterCommand getStudentByadmno(String student);
	public List<Student> listAll(String keyword);


}
