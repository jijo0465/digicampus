package com.monkmind.digicampus.repositories;

import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.models.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {

	Optional<Teacher> findByTeacherId(String teacher);
	Optional<Teacher> findById(Long teacher);
	List<Teacher> findAll();
  
	//Optional<Teacher> findTeacherByTeacherId(String teacher);
}
