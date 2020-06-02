package com.monkmind.digicampus.converters;


import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.RegisterCommand;
import com.monkmind.digicampus.models.Student;

import lombok.Synchronized;


@Component
public class RegisterCommandToStudent implements Converter<RegisterCommand, Student> {
	
	private final GradeCommandToGrade gradeConverter;
	private final SchoolBusCommandToSchoolBus schoolBusConverter;

	public RegisterCommandToStudent(GradeCommandToGrade gradeConverter,SchoolBusCommandToSchoolBus schoolBusConverter) {
		super();
		this.gradeConverter = gradeConverter;
		this.schoolBusConverter= schoolBusConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public Student convert(RegisterCommand source) {
		
		// TODO Auto-generated method stub
		if(source == null)
		{
		return null;
	    }
		
		final Student st =new Student();
		st.setId(source.getId());
		st.setName(source.getName());
		st.setAddress(source.getAddress());
		st.setPhone(source.getPhone());
		st.setAltPhone(source.getAltPhone());
		st.setBloodGroup(source.getBloodGroup());
		st.setDateOfBirth(source.getDob());
		//st.setDisplayImage(source.getDisplayImage());
		st.setHeight(source.getHeight());
		st.setWeight(source.getWeight());
		st.setGender(source.getGender());
		st.setStudentId(source.getStudentId());
		st.setGrade(gradeConverter.convert(source.getGradeid()));
		st.setParent(source.getParentid());
		st.setSchoolBus(schoolBusConverter.convert(source.getSchoolBusid()));
		/*if(source.getGradeid()!=null && source.getGradeid().getId()> 0)
		{
			source.getGradeid()
			.forEach(grade ->st.getGradeid().add(gradeConverter.convert(garde)));
		}*/
		
		
		
		return st;
		

}
}
