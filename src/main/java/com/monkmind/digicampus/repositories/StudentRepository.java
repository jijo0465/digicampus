package com.monkmind.digicampus.repositories;

import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Student;
//import com.monkmind.digicampus.models.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

	Optional<Student> findByStudentId(String student);
	//Optional<Student> findById(Long student);
	List<Student> findAll();
	//void save(RegisterCommand registercommand);
	List<Student> findByGrade(Grade grade);
	Optional<RegisterCommand> findStudentByStudentId(String student);
	 @Query("SELECT p FROM Student p WHERE p.name LIKE ?1%"
	            + " OR p.address LIKE ?1%"
	            + " OR p.studentId LIKE ?1%")
	 public List<Student> search(String keyword);

}
