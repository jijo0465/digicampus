package com.monkmind.digicampus.services;

import org.springframework.stereotype.Service;
import com.monkmind.digicampus.models.TeacherAttendance;
import com.monkmind.digicampus.repositories.TeacherAttendanceRepository;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
//haritha
//date:18/05/2020
public class TeacherAttendanceServiceImpl implements TeacherAttendanceService {
	private final TeacherAttendanceRepository teacherattendanceRepository;
	@Override
	public TeacherAttendance getId(String id) {
		// TODO Auto-generated method stub
		return teacherattendanceRepository.findById(id).get();
	}

	@Override
	public void save(TeacherAttendance teacherAttendance) {
		// TODO Auto-generated method stub
		teacherattendanceRepository.save(teacherAttendance);
	}
}