package com.monkmind.digicampus.models;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name = "period")
@Entity

public class Period extends BaseEntity{
	
	@Column(name = "starting_time")
	private Time startngTime;
	
	@Column(name = "ending_time")
	private Time endingTime;
	
	@ManyToOne
	private StudentTimeTable studentTimeTable;
	
	@ManyToOne
	@NotNull
	private TeacherTimeTable teacherTimeTable;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "period")
    Set<Subject> subjects = new HashSet<>();

}
