package com.monkmind.digicampus.models;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "student")
@Entity
public class Student extends Person{
	
	@Column(name = "Student_id")
	private String studentId;
	
	@Column(name = "height")
    private Double height;
	
	@Column(name = "weight")
    private Double weight;
	
	@ManyToOne
	@NotNull
    private Parent parent;
	
	@ManyToOne
	@NotNull
	private SchoolBus schoolBus;
	
	@ManyToOne
	@NotNull
	private Grade grade;
	
	@ManyToMany
	private Set<Subject> subjects = new HashSet<>();
	
	@OneToMany(mappedBy = "student")
	private Set<StudentAttendance> studentAttendance = new HashSet<>();
	
	
//	@Column(name = "rating")
//	private String rating; 
}
