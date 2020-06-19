package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.ParentCommand;
import com.monkmind.digicampus.models.Parent;

import lombok.Synchronized;

@Component
public class ParentToParentCommand implements Converter<Parent, ParentCommand>{

	
	@Synchronized
	@Nullable
	@Override
	public ParentCommand convert(Parent savedParent) {
		// TODO Auto-generated method stub
		if(savedParent==null)
		{
		return null;
		}
		
		ParentCommand parent=new ParentCommand();
		parent.setId(savedParent.getId());
		parent.setAddress(savedParent.getAddress());
		parent.setPname(savedParent.getName());
		parent.setPaltPhone(savedParent.getAltPhone());
		parent.setPphone(savedParent.getAltPhone());
		parent.setBloodGroup(savedParent.getBloodGroup());
		parent.setParentId(savedParent.getParentId());
		return parent;
		
	}

}
