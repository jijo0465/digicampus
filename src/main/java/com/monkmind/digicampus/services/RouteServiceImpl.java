package com.monkmind.digicampus.services;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.Route;
import com.monkmind.digicampus.repositories.RouteRepository;

import lombok.AllArgsConstructor;

/*author:shijina
created date:17/5/2020
*/

@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService{
	private final RouteRepository routeRepository;
	
	@Override
	public Route getById(String Id) {
		// TODO Auto-generated method stub
		return routeRepository.findById(Id).get();
	}

	@Override
	public Route save(Route route) {
		return routeRepository.save(route);
	}

	@Override
	public Route getRouteById(String Id) {
		// TODO Auto-generated method stub
		return routeRepository.findById(Id).get() ;
	}

}
