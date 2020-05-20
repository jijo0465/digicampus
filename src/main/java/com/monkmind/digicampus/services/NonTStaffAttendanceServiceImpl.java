
package com.monkmind.digicampus.services;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.NonTStaffAttendance;
import com.monkmind.digicampus.repositories.NonTStaffAttendanceRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class NonTStaffAttendanceServiceImpl implements NonTStaffAttendanceService{
private final NonTStaffAttendanceRepository nontstaffattendanceRepository;

@Override
public NonTStaffAttendance getId(Long id) {
	// TODO Auto-generated method stub
	return nontstaffattendanceRepository.findById(id).get();
}

@Override
public NonTStaffAttendance save(NonTStaffAttendance nontstaffattendance) {
	// TODO Auto-generated method stub
	return nontstaffattendanceRepository.save(nontstaffattendance);
}
}