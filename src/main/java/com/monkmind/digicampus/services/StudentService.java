package com.monkmind.digicampus.services;



import com.monkmind.digicampus.models.Student;

public interface StudentService{
    public Student addStudent(Student student);
    public Student getStudentByStudentId(String student);
    public void save(Student student);


}
