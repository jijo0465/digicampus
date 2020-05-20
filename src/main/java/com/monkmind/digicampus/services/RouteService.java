package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.Route;


public interface RouteService {

	 public Route getByRouteId(String routeId);
	 public void save(Route new_route);
}
