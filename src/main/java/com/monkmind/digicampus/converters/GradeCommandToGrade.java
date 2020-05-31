package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.GradeCommand;
import com.monkmind.digicampus.models.Grade;

import lombok.Synchronized;


@Component
public class GradeCommandToGrade implements Converter<GradeCommand, Grade> {

	@Synchronized
	@Override
	public Grade convert(GradeCommand source) {

		if(source == null)
		{
		return null;
	}
		
		final Grade gd=new Grade();
		gd.setId(source.getId());
		gd.setStandard(source.getStandard());
		gd.setDivision(source.getDivision());
		gd.setStrength(source.getStrength());
		return gd;
	}

}
