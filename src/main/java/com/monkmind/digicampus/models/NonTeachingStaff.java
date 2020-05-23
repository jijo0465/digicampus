package com.monkmind.digicampus.models;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "non_teaching_staff")
@Entity

public class NonTeachingStaff extends Person{
	
	@Column(name = "staff_id")
	private String staffId;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "designation")
	private String designation;
	
	@OneToMany(mappedBy = "nonTeachingS")
	private Set<NonTStaffAttendance> nonTeachingSA = new HashSet<>();
	
}
