package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.Route;


public interface RouteService {

	 public Route getById(String Id);
	 public Route save(Route route);
	 public Route getRouteById(String Id);
}
