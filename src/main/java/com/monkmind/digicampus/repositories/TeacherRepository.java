package com.monkmind.digicampus.repositories;

import com.monkmind.digicampus.command.TeacherRegisterCommand;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.Teacher;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {

	Optional<Teacher> findByTeacherId(String teacher);
	Optional<Teacher> findById(Long teacher);
	Optional<Teacher> findByName(Long long1);
	List<Teacher> findAll();
	void save(TeacherRegisterCommand teacherRegisterCommand);
  
	//Optional<Teacher> findTeacherByTeacherId(String teacher);
	@Query("SELECT p FROM Teacher p WHERE p.name LIKE ?1%"
            + " OR p.address LIKE ?1%"
            + " OR p.teacherId LIKE ?1%")
     public List<Teacher> search(String keyword);
}
