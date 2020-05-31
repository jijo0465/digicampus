package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.TeacherRegisterCommand;
import com.monkmind.digicampus.models.Teacher;

@Component
public class TeacherToTeacherRegisterCommand implements Converter<Teacher, TeacherRegisterCommand>{

	@Override
	public TeacherRegisterCommand convert(Teacher source) {
		// TODO Auto-generated method stub
		return null;
	}

}
