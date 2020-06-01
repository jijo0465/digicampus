package com.monkmind.digicampus.command;

import java.util.HashSet;
import java.util.Set;

import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.Teacher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GradeCommand {
	
	private long id;
	private Double standard;
	private String division;
	private Double strength;
	private Set<RegisterCommand> students = new HashSet<>();
	 private TeacherRegisterCommand classTeacher;

}
