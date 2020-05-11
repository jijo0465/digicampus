package com.monkmind.digicampus.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name = "school_bus")
@Entity

public class SchoolBus extends BaseEntity{
	
	@Column(name = "bus_number")
	private Long busNumber;
	
	
	@Column(name = "registration")
	private String registration;
	
	@Column(name = "driver")
	private String driver;
	
	@Column(name = "helper")
	private String helper;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "schoolBus")
    Set<Student> students = new HashSet<>();
	
	@OneToOne(mappedBy = "schoolBus")
    private Route route;
	
}
