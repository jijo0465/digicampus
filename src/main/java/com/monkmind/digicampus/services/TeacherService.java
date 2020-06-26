package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.command.TeacherRegisterCommand;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.Teacher;

public interface TeacherService {

	//public Teacher addTeacher(Teacher teacher);
	public void save(Teacher teacher);
    public Teacher getTeacherByTeacherId(String string);
    public Teacher getById(Long teacher);
    public List<Teacher> findAll();
    public List<Teacher> listAll();
    public void delete(long id);
    public Teacher findById(long l);
    public List<Teacher> listAll(String keyword);
   
    TeacherRegisterCommand saveTeacherRegisterCommand(TeacherRegisterCommand teachercommand);

	//public Object findByName(Long valueOf);
    
}
