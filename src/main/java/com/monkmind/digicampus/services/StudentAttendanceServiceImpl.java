package com.monkmind.digicampus.services;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.StudentAttendance;
import com.monkmind.digicampus.repositories.StudentAttendanceRepository;

import lombok.AllArgsConstructor;
//haritha
//date:18/05/2020
@Service
@AllArgsConstructor
public class StudentAttendanceServiceImpl implements StudentAttendanceService {
	private final StudentAttendanceRepository studentattendanceRepository;

	@Override
	public StudentAttendance getId(Long id) {
		// TODO Auto-generated method stub
		return studentattendanceRepository.findById(id).get();
	}

	@Override
	public StudentAttendance save(StudentAttendance studentAttendance) {
		// TODO Auto-generated method stub
		 return studentattendanceRepository.save(studentAttendance);
	}

	

}