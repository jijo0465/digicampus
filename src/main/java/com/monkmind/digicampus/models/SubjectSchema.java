package com.monkmind.digicampus.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="subject_schema")
@Entity
public class SubjectSchema extends BaseEntity{

	@Column(name="schemaName")
	private String schemaName;
	
	@Column(name="subject_1")
	private String subject1;
	
	@Column(name="subject_2")
	private String subject2;
	
	@Column(name="subject_3")
	private String subject3;
	
	@Column(name="subject_4")
	private String subject4;
	
	@Column(name="subject_5")
	private String subject5;
	
	@Column(name="subject_6")
	private String subject6;
	
	@Column(name="subject_7")
	private String subject7;
	
	@OneToOne()
	private Grade grade;
	
}
