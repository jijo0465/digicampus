package com.monkmind.digicampus.models;

import java.util.HashSet;
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "studentTimeTable")
    private Set<Period> periods = new HashSet<>();

	@OneToOne
	private SubjectSchema subjectschema;
}
