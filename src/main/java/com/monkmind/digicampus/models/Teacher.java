package com.monkmind.digicampus.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "teacher")
@Entity

public class Teacher extends Person{
	@Column(name = "teacher_id")
	private String teacherId;
	
	@Column(name = "password")
	private String Password;

	@JsonIgnore
	@OneToOne(mappedBy = "classTeacher")
    private Grade grade;
	
	@ManyToMany(mappedBy = "teachers")
    private Set<Subject> subjects = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "teacher")
	private Set<TeacherAttendance> teacherAttendance = new HashSet<>();
	
	@OneToMany(mappedBy = "teacher")
    private Set<TeacherTimeTable> teacherTimeTables;
}