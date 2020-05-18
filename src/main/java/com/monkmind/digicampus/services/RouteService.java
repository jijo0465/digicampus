package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.Route;


public interface RouteService {

	 public Route getByRouteId(String route);
	 public void save(Route route);
}
