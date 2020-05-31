package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.command.GradeCommand;
import com.monkmind.digicampus.models.Grade;


public interface GradeService {
	 public Grade getGradeByDivision(String division);
	// public Grade save(Grade grade);
	 public Grade getGradeById(Long id);
	 public List<Grade> listAll();
	 public void delete(Long id);
	 GradeCommand saveGradeCommand(GradeCommand gradecommand);
}
