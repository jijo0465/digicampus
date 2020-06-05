package com.monkmind.digicampus.models;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private StudentTimeTable studentTimeTable;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private TeacherTimeTable teacherTimeTable;
	
	@OneToOne
    Subject subject;

	@OneToOne
	Grade grade;



}
