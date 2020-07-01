package com.monkmind.digicampus.models;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import com.sun.istack.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
    private Parent parent;
	
	@ManyToOne
	private SchoolBus schoolBus;
	
	@ManyToOne
	private Grade grade;
	
	@ManyToMany
	private Set<Subject> subjects = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private Set<StudentAttendance> studentAttendance = new HashSet<>();
	
	@OneToOne()
	private SubjectSchema subjectschema;
	

}
