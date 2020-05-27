package com.monkmind.digicampus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.StudentAttendance;

public interface StudentAttendanceRepository extends CrudRepository<StudentAttendance,Long>{
	Optional<StudentAttendance>findById(String id);
	List<StudentAttendance> findAll();
	Optional<StudentAttendance> findById(Long id);
}
