package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.NonTeachingStaffCommand;
import com.monkmind.digicampus.models.NonTeachingStaff;

import lombok.Synchronized;

@Component
public class NonTeachingStaffCommandToNonTeachingStaff implements Converter<NonTeachingStaffCommand, NonTeachingStaff> {

	@Synchronized
	@Nullable
	@Override
	public NonTeachingStaff convert(NonTeachingStaffCommand source) {
		// TODO Auto-generated method stub
		if(source==null)
		{
		return null;
		}
		final NonTeachingStaff nonTeachingStaff=new NonTeachingStaff();
		nonTeachingStaff.setId(source.getId());
		nonTeachingStaff.setName(source.getName());
		nonTeachingStaff.setAddress(source.getAddress());
		nonTeachingStaff.setAltPhone(source.getAltPhone());
		nonTeachingStaff.setPhone(source.getPhone());
		nonTeachingStaff.setBloodGroup(source.getBloodGroup());
		nonTeachingStaff.setGender(source.getGender());
		nonTeachingStaff.setDateOfBirth(source.getDob());
		nonTeachingStaff.setStaffId(source.getStaffId());
		nonTeachingStaff.setCategory(source.getCategory());
		nonTeachingStaff.setDesignation(source.getDesignation());
		nonTeachingStaff.setNonTeachingSA(source.getNonTeachingSA());
		return nonTeachingStaff;
		
	}

}
