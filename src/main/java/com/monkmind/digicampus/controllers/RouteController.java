package com.monkmind.digicampus.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.monkmind.digicampus.command.GradeCommand;
import com.monkmind.digicampus.command.RouteCommand;
import com.monkmind.digicampus.models.Route;
import com.monkmind.digicampus.models.SchoolBus;
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
	    model.addAttribute("routecommand", new RouteCommand());
	    return "route_form";
	}

	@PostMapping("/routeinsert")
	public String createRoute(@ModelAttribute RouteCommand routecommand,Model model) {
		 RouteCommand savedCommand=routeService.saveRouteCommand(routecommand);
	    model.addAttribute("routecommand",routecommand);
	    return "redirect:/";
	}	
	
	@RequestMapping("/routedisplay")
	public String displayRoute(@ModelAttribute Route route,Model model) {
		List<Route> listroutes=routeService.listAll();
		model.addAttribute("listroutes", listroutes);
	    return "routedisplay";
	}
	@RequestMapping("/abc/{route}")
	public String routeEdit(@PathVariable String route,Model model) {
		System.out.println(route);
	    Route routes = routeService.getRouteById(new String(route));
	    model.addAttribute("route",routes);
	     return "updateroute";
	}
	@RequestMapping("/def/{id}")
	public String deleteRoute(@PathVariable Long id,Model model)
	{
		routeService.delete(id);
		return "redirect:/";
		
	}
}
