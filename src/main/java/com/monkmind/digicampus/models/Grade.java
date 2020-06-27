package com.monkmind.digicampus.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private int standard;
	
	@Column(name = "division")
    private String division;
	
	@Column(name = "strength")
    private Double strength;
	
	//@Column(name = "max_strength")
    //private Double max_strength;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grade")
    private Set<StudentTimeTable> studentTimeTable = new HashSet<>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grade")
    private Set<Student> students = new HashSet<>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grade")
	private Set<Test> test  = new HashSet<>();

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
    private Teacher classTeacher;

//	@OneToOne(mappedBy = "grade",fetch = FetchType.LAZY)
//	private Period period;
	//@ManyToMany
	//@JoinTable(name="grade_exams",joinColumns=@JoinColumn(name="grade_id"),inverseJoinColumns =@JoinColumn(name="exam_id"))
	
	@OneToOne(mappedBy="grade")
	private SubjectSchema subjectschema;
	
	
//	@Column(name = "rating")
//	private String rating; 
}
