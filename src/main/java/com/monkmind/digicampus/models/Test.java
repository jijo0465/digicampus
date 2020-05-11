package com.monkmind.digicampus.models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "test")
@Entity

public class Test extends BaseEntity{
	@Column(name = "total_mark")
    private Double totalMark;
	
	@Column(name = "pass_mark")
    private Double passMark;
	
	@Column(name = "duration")
    private Time duration;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "time")
	private Time time;
	
	@ManyToOne
	private Subject subjectName;
	
	@ManyToOne
	private Exam exam;
	
	
}
