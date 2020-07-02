package com.monkmind.digicampus.services.service_impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.command.RouteCommand;
import com.monkmind.digicampus.converters.RouteCommandToRoute;
import com.monkmind.digicampus.converters.RouteToRouteCommand;
import com.monkmind.digicampus.models.Route;
import com.monkmind.digicampus.repositories.RouteRepository;
import com.monkmind.digicampus.services.RouteService;

import lombok.AllArgsConstructor;

/*author:shijina
created date:17/5/2020
*/

@Service
@AllArgsConstructor
public class RouteServiceImpl implements RouteService{
	private final RouteRepository routeRepository;
	private final RouteCommandToRoute routeCommandToRoute;
	private final RouteToRouteCommand routeToRouteCommand;
	
	@Override
	public Route getById(String Id) {
		// TODO Auto-generated method stub
		return routeRepository.findById(Id).get();
	}

	/*@Override
	public Route save(Route route) {
		return routeRepository.save(route);
	}
	*/

	@Override
	public Route getRouteById(String Id) {
		// TODO Auto-generated method stub
		return routeRepository.findById(Id).get() ;
	}

	@Override
	public List<Route> listAll() {
		// TODO Auto-generated method stub
		return routeRepository.findAll();
	}

	@Override
	public void delete(Long Id) {
		// TODO Auto-generated method stub
		routeRepository.deleteById(Id);;
	}

	@Override
	@Transactional
	
	public RouteCommand saveRouteCommand(RouteCommand routecommand) {
		// TODO Auto-generated method stub
			Route detachedRoute=routeCommandToRoute.convert(routecommand);
			Route savedRoute=routeRepository.save(detachedRoute);
			//log.debug("saved studentid :"+ savedStudent.getId());
			return routeToRouteCommand.convert(savedRoute) ;
		}

	}


