package com.monkmind.digicampus.repositories;

import com.monkmind.digicampus.models.Student;
//import com.monkmind.digicampus.models.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
	Optional<Student> findByStudentId(String student);
	Optional<Student> findById(Long student);
	
}
