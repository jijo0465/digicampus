package com.monkmind.digicampus.repositories;

import java.util.List;
import java.util.Optional;

import com.monkmind.digicampus.models.Grade;
import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.SubjectSchema;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectSchemaRepository extends CrudRepository<SubjectSchema, Long> {
	
	List<SubjectSchema> findAll();
	List<SubjectSchema> findByGrade(Grade grade);

	Optional<SubjectSchema> findById(Long id);

}
