
package com.monkmind.digicampus.services;

import java.util.List;

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

@Override
public List<NonTStaffAttendance> listAll() {
	// TODO Auto-generated method stub
	return nontstaffattendanceRepository.findAll();
}

@Override
public void delete(long id) {
	// TODO Auto-generated method stub
	nontstaffattendanceRepository.deleteById(id);
}
}