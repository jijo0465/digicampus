package com.monkmind.digicampus.command;

import java.util.HashSet;
import java.util.Set;



import com.monkmind.digicampus.models.WeekDay;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class StudentTimeTableCommand {
	
	 private long id;
	 private WeekDay day;
	 private GradeCommand gradeid;
	 private Set<PeriodCommand> periodid = new HashSet<>();
}
