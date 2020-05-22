package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.Exam;


public interface ExamService {
	
	public Exam getById(Exam exam);
	public void save(Exam exam);
	public Exam getExamById(Long long1);
	 

}
