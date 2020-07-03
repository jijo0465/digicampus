package com.monkmind.digicampus.models;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@Column(name = "period_no")
	private Integer periodNo;

	@Column(name = "ending_time")
	private Time endingTime;

	@JsonIgnore
	@ManyToOne
	private StudentTimeTable studentTimeTable;

	@JsonIgnore
	@ManyToOne
	private TeacherTimeTable teacherTimeTable;
	
	@ManyToOne
    private Subject subject;

	@Enumerated(EnumType.STRING)
	private WeekDay weekDay;

	@ManyToOne
	private SubjectSchema subjectSchema;

}
