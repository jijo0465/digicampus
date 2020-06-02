package com.monkmind.digicampus.command;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GradeCommand {
	
	private long id;
	private int standard;
	private String division;
	private Double strength;
	private Set<RegisterCommand> students = new HashSet<>();
	 private TeacherRegisterCommand classTeacher;

}
