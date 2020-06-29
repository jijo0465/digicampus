package com.monkmind.digicampus.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.SubjectSchema;
import com.monkmind.digicampus.models.Teacher;

public interface SubjectSchemaRepository extends CrudRepository<SubjectSchema, Long> {
	
	List<SubjectSchema> findAll();

}
