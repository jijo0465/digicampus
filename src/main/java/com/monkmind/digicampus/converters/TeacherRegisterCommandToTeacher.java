package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.TeacherRegisterCommand;

import com.monkmind.digicampus.models.Teacher;

import lombok.Synchronized;


@Component
public class TeacherRegisterCommandToTeacher implements Converter<TeacherRegisterCommand, Teacher> {

	private final GradeCommandToGrade gradeConverter;
	
	
	public TeacherRegisterCommandToTeacher(GradeCommandToGrade gradeConverter) {
		super();
		this.gradeConverter = gradeConverter;
	}


	@Synchronized
	@Nullable
	@Override
	public Teacher convert(TeacherRegisterCommand source) {
		// TODO Auto-generated method stub
		if(source == null)
		{
		return null;
	    }
		
		final Teacher teacher =new Teacher();
		teacher.setId(source.getId());
		teacher.setName(source.getName());
		teacher.setAddress(source.getAddress());
		teacher.setPhone(source.getPhone());
		teacher.setAltPhone(source.getAltPhone());
		teacher.setDateOfBirth(source.getDob());
		teacher.setGender(source.getGender());
		teacher.setDisplayImage(source.getDisplayImage());
		teacher.setGrade(gradeConverter.convert(source.getGrade()));
		teacher.setBloodGroup(source.getBloodGroup());
		return teacher;
		
	}

}
