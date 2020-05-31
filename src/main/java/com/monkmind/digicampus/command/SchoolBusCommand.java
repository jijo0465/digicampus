package com.monkmind.digicampus.command;

import java.util.HashSet;
import java.util.Set;

import com.monkmind.digicampus.models.Route;
import com.monkmind.digicampus.models.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class SchoolBusCommand {
	
	private long id;
	private Long busNumber;
	private String registration;
	private String driver;
	private String helper;
	Set<RegisterCommand> students = new HashSet<>();
	private RouteCommand route;

}
