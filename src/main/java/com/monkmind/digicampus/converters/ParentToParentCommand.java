package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.ParentCommand;
import com.monkmind.digicampus.models.Parent;

@Component
public class ParentToParentCommand implements Converter<Parent, ParentCommand>{

	public ParentCommand convert(Parent savedParent) {
		// TODO Auto-generated method stub
		return null;
	}

}
