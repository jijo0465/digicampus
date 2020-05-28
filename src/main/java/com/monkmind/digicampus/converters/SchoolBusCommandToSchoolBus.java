package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.SchoolBusCommand;
import com.monkmind.digicampus.models.SchoolBus;

import lombok.Synchronized;

@Component
public class SchoolBusCommandToSchoolBus implements Converter<SchoolBusCommand, SchoolBus>{
	
	
	private final RouteCommandToRoute routeConverter;
	

	public SchoolBusCommandToSchoolBus(RouteCommandToRoute routeConverter) {
		super();
		this.routeConverter = routeConverter;
	}
	
	
	@Synchronized
	@Override
	public SchoolBus convert(SchoolBusCommand source) {
		// TODO Auto-generated method stub
		if(source == null)
		{
		return null;
	    }
		
		final SchoolBus schoolBus=new SchoolBus();
		schoolBus.setBusNumber(source.getBusNumber());
		schoolBus.setDriver(source.getDriver());
		schoolBus.setHelper(source.getHelper());
		schoolBus.setRegistration(source.getRegistration());
		schoolBus.setRoute(routeConverter.convert(source.getRoute()));
		return schoolBus;
	}
	

}
