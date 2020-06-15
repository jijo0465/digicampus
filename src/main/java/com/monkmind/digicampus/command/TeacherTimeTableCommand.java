package com.monkmind.digicampus.command;

import java.util.HashSet;
import java.util.Set;


import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.models.WeekDay;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class TeacherTimeTableCommand {

	 private long id;
	 private WeekDay day;
	 Set<PeriodCommand> periodid = new HashSet<>();
	 private TeacherRegisterCommand teacher;
}
