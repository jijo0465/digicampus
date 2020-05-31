package com.monkmind.digicampus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.command.RouteCommand;
import com.monkmind.digicampus.models.Route;


public interface RouteRepository extends CrudRepository<Route, Long> {

	Optional<Route> findById(String new_route);
	List<Route> findAll();
	void save(RouteCommand routecommand);
}
