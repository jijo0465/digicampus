package com.monkmind.digicampus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.models.Route;

import com.monkmind.digicampus.services.RouteService;

/*author:shijina
created date:17/5/2020
*/
@Controller
public class RouteController {

	private final RouteService routeService;

	public RouteController(RouteService routeService) {
		super();
		this.routeService = routeService;
	}
	@RequestMapping("/route")
	public String routeForm(Model model) {
	    model.addAttribute("new_route", new Route());
	    return "route_form";
	}

	@PostMapping
	@RequestMapping("/routeinsert")
	public String createRoute(@ModelAttribute Route new_route,Model model) {
	    routeService.save(new_route);
	    return "index";
	}
}
