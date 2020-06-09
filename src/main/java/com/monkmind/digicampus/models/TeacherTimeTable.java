package com.monkmind.digicampus.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Table(name = "teacher_time_table")
@Entity

public class TeacherTimeTable extends BaseEntity{

	@Enumerated(EnumType.STRING)
	@Column(name = "day")
    private WeekDay day;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherTimeTable")
    Set<Period> periods = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Teacher teacher;
}
