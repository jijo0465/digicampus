package com.monkmind.digicampus.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.TeacherTimeTable;

public interface TeacherTimeTableRepository extends CrudRepository<TeacherTimeTable, Long> {
	Optional<TeacherTimeTable> findById(String teachertimetable);
}
