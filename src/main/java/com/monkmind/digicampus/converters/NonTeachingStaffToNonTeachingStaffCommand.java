package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.NonTeachingStaffCommand;
import com.monkmind.digicampus.models.NonTeachingStaff;

@Component
public class NonTeachingStaffToNonTeachingStaffCommand implements Converter<NonTeachingStaff, NonTeachingStaffCommand>{

	@Override
	public NonTeachingStaffCommand convert(NonTeachingStaff source) {
		// TODO Auto-generated method stub
		return null;
	}

}
