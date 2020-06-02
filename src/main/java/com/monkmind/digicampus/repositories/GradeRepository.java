package com.monkmind.digicampus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.command.GradeCommand;
import com.monkmind.digicampus.models.Grade;


public interface GradeRepository extends CrudRepository<Grade, Long> {

	Optional<Grade> findByDivision(String division);
	List<Grade> findAll();
	Optional<Grade> findById(Long id);
	void save(GradeCommand gradecommand);
	
}
