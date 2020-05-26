package com.monkmind.digicampus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.NonTStaffAttendance;
import com.monkmind.digicampus.models.Student;


public interface NonTStaffAttendanceRepository extends CrudRepository<NonTStaffAttendance, Long>{
	Optional<NonTStaffAttendance>findById(Long id);
	List<NonTStaffAttendance> findAll();
}
