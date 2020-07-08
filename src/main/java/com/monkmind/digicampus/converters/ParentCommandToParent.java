package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.ParentCommand;
import com.monkmind.digicampus.models.Parent;

import lombok.Synchronized;

@Component
public class ParentCommandToParent implements Converter<ParentCommand, Parent> {

	
	@Synchronized
	@Nullable
	@Override
	public Parent convert(ParentCommand source) {
		// TODO Auto-generated method stub
		if(source == null)
		{
		return null;
	    }
		final Parent parent = new Parent();
		parent.setId(source.getId());
		parent.setName(source.getPname());
		parent.setParentId(source.getParentId());
		parent.setAltPhone(source.getPaltPhone());
		parent.setPhone(source.getPphone());
		return parent;
	}

}
