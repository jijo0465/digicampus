package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.Exam;


public interface ExamService {
	
	public Exam getExamById(String exam);
	 public void save(Exam exam);

}
