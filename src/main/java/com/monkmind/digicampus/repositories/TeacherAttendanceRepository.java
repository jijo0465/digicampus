package com.monkmind.digicampus.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.monkmind.digicampus.models.TeacherAttendance;
//haritha
//date:18/05/2020
public interface TeacherAttendanceRepository extends CrudRepository<TeacherAttendance,Long> {
	Optional<TeacherAttendance>findById(String id);
}
