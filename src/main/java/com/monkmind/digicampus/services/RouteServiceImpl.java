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
	public Route getByRouteId(String routeId) {
		// TODO Auto-generated method stub
		return routeRepository.findByRouteId(routeId).get();
	}

	@Override
	public void save(Route new_route) {
		// TODO Auto-generated method stub
		routeRepository.save(new_route);
	}

}
