package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.models.Exam;



public interface ExamService {
	
	public Exam getById(Exam exam);
	public Exam save(Exam exam);
	public Exam getExamById(Long long1);

	public List<Exam> listAll();
	public void delete(long id); 


}
