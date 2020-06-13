package com.monkmind.digicampus.converters;

import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.GradeCommand;
import com.monkmind.digicampus.models.Grade;

@Component
public class GradeToGradeCommand {

	public GradeCommand convert(Grade savedGrade) {
		// TODO Auto-generated method stub
		if(savedGrade==null) {
			return null;
		}
		
		final GradeCommand gd=new GradeCommand();
		gd.setId(savedGrade.getId());
		gd.setStandard(savedGrade.getStandard());
		gd.setDivision(savedGrade.getDivision());
		gd.setStrength(savedGrade.getStrength());
		return gd;
		
	}
		
	}


