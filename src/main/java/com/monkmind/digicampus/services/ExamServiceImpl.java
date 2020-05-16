package com.monkmind.digicampus.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.Exam;
import com.monkmind.digicampus.repositories.ExamRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExamServiceImpl implements ExamService {

	private final ExamRepository examRepository;
	@Override
	public Exam getExamById(String exam) {
		// TODO Auto-generated method stub
		return examRepository.findById(exam).get();
	}

	@Override
	public void save(Exam exam) {
		// TODO Auto-generated method stub
		examRepository.save(exam);
	}

	
}
