package com.monkmind.digicampus.services;



import java.util.List;

import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.models.Grade;
//import com.monkmind.digicampus.controllers.List;
import com.monkmind.digicampus.models.Student;

public interface StudentService{
    public Student addStudent(Student student);
    public Student getStudentByStudentId(String student);
    //public void save(Student student);
    public Student get(long id);
	public List<Student> listAll(); 
	public void delete(long id);
	Student findById(long l);
	RegisterCommand findCommandById(long l);

	RegisterCommand saveRegisterCommand(RegisterCommand command);
	public List<Student> findByGradeid(Grade grade);


}
