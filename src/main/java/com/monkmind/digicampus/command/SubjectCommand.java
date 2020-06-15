package com.monkmind.digicampus.command;

import java.util.HashSet;
import java.util.Set;

import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.models.Student;
import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.models.Test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class SubjectCommand {
	
	private String name;
	private Boolean isExamable;
	private Boolean optional;
	private Set<TeacherRegisterCommand> teachers = new HashSet<>();
	 private Set<RegisterCommand> students = new HashSet<>();
	 Set<Test> tests = new HashSet<>();
	 private PeriodCommand period;

}
