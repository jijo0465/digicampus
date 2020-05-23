package com.monkmind.digicampus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

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
@Table(name = "teacher_attendance")
@Entity

public class TeacherAttendance extends BaseEntity{
	
	@ManyToOne
	@NotNull
	private Teacher teacher;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "date")
	private String date;
	
	@Column(name = "attendance")
	private Boolean yes;

}
