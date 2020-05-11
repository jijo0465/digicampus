package com.monkmind.digicampus.models;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "bus_route")
@Entity

public class Route extends BaseEntity{
	
	@Column(name = "route_id")
	private Long routeId;
	
	@Column(name = "route")
	private String route;
	
	@Column(name = "starting_time")
	private Time startngTime;
	
	@Column(name = "arrival")
	private Time arrival;
	
	@Column(name = "departure")
	private Time departure;
	
	@Column(name = "ending_time")
	private Time endingTime;
	
	@OneToOne
	private SchoolBus schoolBus;
}
