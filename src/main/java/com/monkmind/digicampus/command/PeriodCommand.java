package com.monkmind.digicampus.command;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import com.monkmind.digicampus.models.StudentTimeTable;
import com.monkmind.digicampus.models.Subject;
import com.monkmind.digicampus.models.TeacherTimeTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PeriodCommand {

	private long id;
	private Time startngTime;
	private Time endingTime;
	private StudentTimeTableCommand studentTimeTable;
	private TeacherTimeTable teacherTimeTable;
	Set<SubjectCommand> subjects = new HashSet<>();
}
