package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.models.Route;


public interface RouteService {

	 public Route getById(String Id);
	 public Route save(Route route);
	 public List<Route> listAll();
	 public Route getRouteById(String Id);
	 public void delete(Long Id);
}
