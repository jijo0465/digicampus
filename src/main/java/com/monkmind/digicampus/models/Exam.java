package com.monkmind.digicampus.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "exam")
@Entity

public class Exam extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;

	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "exam")
    private Set<Test> tests = new HashSet<>();
	
	//@ManyToMany(cascade = CascadeType.ALL ,mappedBy = "exams")
	//private Set<Grade> grades = new HashSet<>();

	
	
}
