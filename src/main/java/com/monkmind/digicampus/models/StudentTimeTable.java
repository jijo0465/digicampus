package com.monkmind.digicampus.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Table(name = "student_time_table")
@Entity
public class StudentTimeTable extends BaseEntity{

	@Enumerated(EnumType.STRING)
	@Column(name = "day")
    private WeekDay day;
	
	@ManyToOne
	private Grade grade;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "studentTimeTable")
    private List<Period> periods = new ArrayList<>();

	@OneToOne
	private SubjectSchema subjectschema;

	public void addPeriod(Period period){
		this.periods.add(period);
	}

}
