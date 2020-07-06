package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.StudentTimeTableCommand;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.StudentTimeTable;

import lombok.Synchronized;

@Component
public class StudentTimeTableCommandToStudentTimeTable implements Converter<StudentTimeTableCommand, StudentTimeTable> {
		
		private final GradeCommandToGrade gradeConverter;
	
	
	public StudentTimeTableCommandToStudentTimeTable(GradeCommandToGrade gradeConverter) {
			super();
			this.gradeConverter = gradeConverter;
		}


	@Synchronized
	@Nullable
	@Override
	public StudentTimeTable convert(StudentTimeTableCommand source) {
		// TODO Auto-generated method stub
		if(source == null)
		{
		return null;
	}
		
		final StudentTimeTable studenttimetable=new StudentTimeTable();
		studenttimetable.setId(source.getId());
		//studenttimetable.setPeriod(periodC(source.getPeriodid());
		return studenttimetable;
	}

}
