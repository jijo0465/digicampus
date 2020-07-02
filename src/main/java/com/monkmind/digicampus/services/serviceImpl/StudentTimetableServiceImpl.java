package com.monkmind.digicampus.services.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.command.StudentTimeTableCommand;
import com.monkmind.digicampus.converters.StudentTimeTableCommandToStudentTimeTable;
import com.monkmind.digicampus.converters.StudentTimeTableToStudentTimetableCommand;
import com.monkmind.digicampus.models.Grade;

import com.monkmind.digicampus.models.StudentTimeTable;


import com.monkmind.digicampus.repositories.StudentTimetableRepository;
import com.monkmind.digicampus.services.StudentTimetableService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentTimetableServiceImpl implements StudentTimetableService{
	
	private final StudentTimetableRepository studenttimetableRepository;
	private final StudentTimeTableCommandToStudentTimeTable studentTimeTableCommandToStudentTimeTable;
	private final StudentTimeTableToStudentTimetableCommand studentTimeTableToStudentTimeTableCommand;
	

	@Override
	public StudentTimeTable getById(Long id) {
		// TODO Auto-generated method stub
		return studenttimetableRepository.findById(id).get();
	}

	@Override
	public StudentTimeTable  save(StudentTimeTable studentTimetable) {
		// TODO Auto-generated method stub
		 return studenttimetableRepository.save(studentTimetable);
	}

	@Override
	public StudentTimeTable getByDay(Long day) {
		// TODO Auto-generated method stub
		return studenttimetableRepository.findByDay(day).get();
	}

	@Override
	public List<StudentTimeTable> findAll() {
		// TODO Auto-generated method stub
		return studenttimetableRepository.findAll();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		studenttimetableRepository.deleteById(id);
	}

	@Override
	public List<StudentTimeTable> findByGrade(Grade grade){
		return studenttimetableRepository.findByGrade(grade);
	}

	@Transactional
	@Override
	public StudentTimeTableCommand saveStudentTimeTableCommand(StudentTimeTableCommand command) {
		StudentTimeTable detachedStudentTimeTable=studentTimeTableCommandToStudentTimeTable.convert(command);
		StudentTimeTable savedStudentTimeTable=studenttimetableRepository.save(detachedStudentTimeTable);
		//log.debug("saved studentid :"+ savedStudent.getId());
		return studentTimeTableToStudentTimeTableCommand.convert(savedStudentTimeTable) ;
	}
		
	



	
	
	
	
	

}
