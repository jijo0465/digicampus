package com.monkmind.digicampus.command;

import java.sql.Date;
import java.sql.Time;

import com.monkmind.digicampus.models.Exam;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Subject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TestCommand {
	
	private long id;
	private Double totalMark;
	private Double passMark;
	private Time duration;
	private Date date;
	private Time time;
	private SubjectCommand subjectName;
	private ExamCommand exam;
	private GradeCommand grade;
}
