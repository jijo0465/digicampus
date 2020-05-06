package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.models.Person;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.repositories.ParentRepository;
import com.monkmind.digicampus.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;

    @Override
    public Student addStudent(Student student) {
        addParent(student.getParent());
        studentRepository.save(student);
        return (Student) student;
    }

    public void addParent(Parent parent){
        parentRepository.save(parent);
    }
}
