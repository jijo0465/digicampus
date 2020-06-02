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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Table(name = "grade")
@Entity

public class Grade extends BaseEntity{

	@Column(name = "standard")
	private Double standard;
	
	@Column(name = "division")
    private String division;
	
	@Column(name = "strength")
    private Double strength;
	
	//@Column(name = "max_strength")
    //private Double max_strength;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grade")
    private Set<StudentTimeTable> studentTimeTable = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grade")
    private Set<Student> students = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grade")
	private Set<Test> test  = new HashSet<>();
	
	@OneToOne
    private Teacher classTeacher;
	
	//@ManyToMany
	//@JoinTable(name="grade_exams",joinColumns=@JoinColumn(name="grade_id"),inverseJoinColumns =@JoinColumn(name="exam_id"))
	
	
	
	
//	@Column(name = "rating")
//	private String rating; 
}
