package com.monkmind.digicampus.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.monkmind.digicampus.command.RouteCommand;
import com.monkmind.digicampus.models.Route;

import lombok.Synchronized;

@Component
public class RouteCommandToRoute implements Converter<RouteCommand, Route>{

	@Synchronized
	@Override
	public Route convert(RouteCommand source) {
		// TODO Auto-generated method stub
		if(source == null)
		{
		return null;
	}
		final Route route=new Route();
		route.setRouteName(source.getRouteName());
		route.setStartngTime(source.getStartngTime());
		route.setArrival(source.getArrival());
		route.setDeparture(source.getDeparture());
		route.setEndingTime(source.getEndingTime());
		return route;
	}

}
