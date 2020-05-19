package com.monkmind.digicampus.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.monkmind.digicampus.models.StudentTimeTable;

@Repository
public interface StudentTimetableRepository extends CrudRepository<StudentTimeTable, Long> {

	
	Optional<StudentTimeTable> findById(Long id);
}
