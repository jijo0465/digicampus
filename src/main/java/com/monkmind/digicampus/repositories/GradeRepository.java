package com.monkmind.digicampus.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.Grade;


public interface GradeRepository extends CrudRepository<Grade, Long> {

	Optional<Grade> findByDivision(String division);

	//void save(Grade grade);
}
