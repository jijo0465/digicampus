package com.monkmind.digicampus.models;

import javax.persistence.*;

//import javax.persistence.OneToOne;

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

	@ManyToOne
	private Subject subject1,subject2,subject3,subject4,subject5,subject6,subject7;
	
	@ManyToOne
	private Grade grade;
	
}
