package com.monkmind.digicampus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.models.TeacherTimeTable;

public interface PeriodRepository extends CrudRepository<Period,Long>{
	Optional<Period>findById(String Period);
	List<Period> findAll();
	Optional<Period> findById(Long id);
	List<Period> findByStudentTimeTable(StudentTimeTable studentTimeTable);
	List<Period> findByTeacherTimeTable(TeacherTimeTable teacherTimeTable);
		
}
