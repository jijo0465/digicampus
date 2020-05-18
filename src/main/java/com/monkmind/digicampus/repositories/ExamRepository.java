package com.monkmind.digicampus.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.Exam;


public interface ExamRepository extends CrudRepository<Exam, Long>{
	
	Optional<Exam> findById(String exam);
	Optional<Exam> findById(Long exam);
	

}
