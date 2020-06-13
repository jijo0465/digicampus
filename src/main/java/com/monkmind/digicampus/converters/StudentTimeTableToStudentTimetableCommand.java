package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.StudentTimeTableCommand;
import com.monkmind.digicampus.models.StudentTimeTable;

import lombok.Synchronized;

@Component
public class StudentTimeTableToStudentTimetableCommand implements Converter<StudentTimeTable, StudentTimeTableCommand> {

	

	
	@Override
	public StudentTimeTableCommand convert(StudentTimeTable source) {
		// TODO Auto-generated method stub
		
		return null;
	}
		
}


