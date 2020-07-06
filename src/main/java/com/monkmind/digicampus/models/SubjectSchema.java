package com.monkmind.digicampus.models;

import javax.persistence.*;

//import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="subject_schema")
@Entity
public class SubjectSchema extends BaseEntity{

	@Column(name="schemaName")
	private String schemaName;

	@ManyToMany
	private Set<Subject> subjects;

	@JsonIgnore
	@ManyToOne
	private Grade grade;

	@JsonIgnore
	@OneToMany(mappedBy="subjectschema")
	private Set<Student> student;

	@JsonIgnore
	@OneToOne
	private StudentTimeTable studentTimetable;

	
}
