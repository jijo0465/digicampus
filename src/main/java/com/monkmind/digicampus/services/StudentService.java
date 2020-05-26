package com.monkmind.digicampus.services;



import java.util.List;

//import com.monkmind.digicampus.controllers.List;
import com.monkmind.digicampus.models.Student;

public interface StudentService{
    public Student addStudent(Student student);
    public Student getStudentByStudentId(String student);
    public void save(Student student);
    public Student get(long studentId);
	public List<Student> listAll(); 
	public void delete(long id);


}
