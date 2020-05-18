package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.Grade;


public interface GradeService {
	 public Grade getGradeByDivision(String division);
	 public void save(Grade grade);
	 public Grade getGradeById(Long id);

}
