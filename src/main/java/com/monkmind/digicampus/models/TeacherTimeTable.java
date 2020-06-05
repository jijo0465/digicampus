package com.monkmind.digicampus.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "teacher_time_table")
@Entity

public class TeacherTimeTable extends BaseEntity{

	@Enumerated(EnumType.STRING)
	@Column(name = "day")
    private WeekDay day;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherTimeTable")
    Set<Period> periods = new HashSet<>();

	@JsonIgnore
	@ManyToOne
	private Teacher teacher;

}
