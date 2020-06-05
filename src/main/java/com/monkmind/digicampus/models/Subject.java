package com.monkmind.digicampus.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

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
@Table(name = "subject")
@Entity

public class Subject extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "is_examable")
	private Boolean isExamable;

	@Column(name = "optional")
	private Boolean optional;

	@JsonIgnore
	@ManyToMany
    private Set<Teacher> teachers = new HashSet<>();

	@JsonIgnore
	@ManyToMany(mappedBy = "subjects")
    private Set<Student> students = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "subjectName")
	Set<Test> tests = new HashSet<>();
	
//	@OneToOne(mappedBy = "subject")
//	private Period period;
}
