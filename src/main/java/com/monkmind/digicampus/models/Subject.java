package com.monkmind.digicampus.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "subject")
@Entity

public class Subject extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "is_examable")
	private Boolean isExamable;

	@Column(name = "optional")
	private Boolean optional;
	
	@ManyToMany
    private Set<Teacher> teachers = new HashSet<>();
	
	@ManyToMany(mappedBy = "subjects")
    private Set<Student> students = new HashSet<>();
	
	@OneToMany(mappedBy = "subjectName")
	Set<Test> tests = new HashSet<>();
	
	@ManyToOne
	private Period period;
}
