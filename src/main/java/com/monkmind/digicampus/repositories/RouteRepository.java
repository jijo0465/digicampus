package com.monkmind.digicampus.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.Route;


public interface RouteRepository extends CrudRepository<Route, Long> {

	Optional<Route> findByRouteId(String new_route);
}
