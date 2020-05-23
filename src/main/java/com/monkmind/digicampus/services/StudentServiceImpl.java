package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.Parent;

import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.repositories.ParentRepository;
import com.monkmind.digicampus.repositories.StudentRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;

    @Override
    public Student addStudent(Student student) {
        addParent(student.getParent());
        return studentRepository.save(student);
    }

    public void addParent(Parent parent){
        parentRepository.save(parent);
    }

    @Override
	public Student getStudentByStudentId(String student) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentId(student).orElse(null);
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
	}

	@Override
	public Student get(long studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentId).get();
	}

	@Override
	public List<Student> listAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
}
