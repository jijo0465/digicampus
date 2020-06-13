package com.monkmind.digicampus.command;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ExamCommand {
	
	private String name;
	private Date startDate;
	private Date endDate;
	private Set<TestCommand> tests = new HashSet<>();

}
