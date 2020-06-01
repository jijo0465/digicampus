package com.monkmind.digicampus.converters;

import javax.validation.constraints.Null;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.models.Student;

import lombok.Synchronized;

@Component
public class StudentToRegisterCommand implements Converter<Student, RegisterCommand>{
	
	
	private final GradeToGradeCommand gradeConverter;
	private final SchoolBusToSchoolBusCommand schoolBusConverter;

	public StudentToRegisterCommand(GradeToGradeCommand gradeConverter,
			SchoolBusToSchoolBusCommand schoolBusConverter) {
		super();
		this.gradeConverter = gradeConverter;
		this.schoolBusConverter = schoolBusConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public RegisterCommand convert(Student savedStudent) {
		// TODO Auto-generated method stub
	if(savedStudent ==null)
		{
		return null;
		}
	
	RegisterCommand registerCommand=new RegisterCommand();
	registerCommand.setId(savedStudent.getId());
	registerCommand.setName(savedStudent.getName());
	registerCommand.setAddress(savedStudent.getAddress());
	registerCommand.setAltPhone(savedStudent.getAltPhone());
	registerCommand.setPhone(savedStudent.getPhone());
	registerCommand.setBloodGroup(savedStudent.getBloodGroup());
	//registerCommand.setDisplayImage(savedStudent.getDisplayImage());
	registerCommand.setDob(savedStudent.getDateOfBirth());
	registerCommand.setHeight(savedStudent.getHeight());
	registerCommand.setWeight(savedStudent.getHeight());
	registerCommand.setGender(savedStudent.getGender());
	registerCommand.setGradeid(gradeConverter.convert(savedStudent.getGrade()));
	registerCommand.setSchoolBusid(schoolBusConverter.convert(savedStudent.getSchoolBus()));
	registerCommand.setStudentId(savedStudent.getStudentId());
	return registerCommand;
	
	
	
	
	
	
	
	
	}

	
}
