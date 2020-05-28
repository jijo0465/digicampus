package com.monkmind.digicampus.converters;

import javax.validation.constraints.NotNull;


import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.controllers.GradeController;
import com.monkmind.digicampus.models.Student;

import lombok.Synchronized;


@Component
public class RegisterCommandToStudent implements Converter<RegisterCommand, Student> {
	
	private final GradeCommandToGrade gradeConverter;

	public RegisterCommandToStudent(GradeCommandToGrade gradeConverter) {
		super();
		this.gradeConverter = gradeConverter;
	}

	@Synchronized
	@NotNull
	@Override
	public Student convert(RegisterCommand source) {
		
		// TODO Auto-generated method stub
		if(source == null)
		{
		return null;
	    }
		
		final Student st =new Student();
		st.setName(source.getName());
		st.setAddress(source.getAddress());
		st.setPhone(source.getPhone());
		st.setAltPhone(source.getAltPhone());
		st.setBloodGroup(source.getBloodGroup());
		st.setDateOfBirth(source.getDob());
		st.setDisplayImage(source.getDisplayImage());
		st.setHeight(source.getHeight());
		st.setWeight(source.getWeight());
		st.setGender(source.getGender());
		st.setStudentId(source.getStudentId());
		st.setGrade(gradeConverter.convert(source.getGradeid()));
		st.setParent(source.getParentid());
		st.setSchoolBus(source.getSchoolBusid());
		return st;
		

}
}
