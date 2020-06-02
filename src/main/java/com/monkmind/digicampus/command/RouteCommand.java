package com.monkmind.digicampus.command;

import java.sql.Time;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RouteCommand {

	private long Id;
	private String routeName;
	private Time startngTime;
	private Time arrival;
	private Time departure;
	private Time endingTime;
	private SchoolBusCommand schoolBus;
}
