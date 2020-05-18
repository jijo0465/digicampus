package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Route;

import com.monkmind.digicampus.services.RouteService;

@Controller
public class RouteController {

	private final RouteService routeService;

	public RouteController(RouteService routeService) {
		super();
		this.routeService = routeService;
	}
	@RequestMapping("/route")
	public String routeForm(Model model) {
	    model.addAttribute("route", new Route());
	    return "route_form";
	}

	@PostMapping
	@RequestMapping("/routeinsert")
	public String createRoute(@ModelAttribute Route route,Model model) {
	    routeService.save(route);
	    return "index";
	}
}
