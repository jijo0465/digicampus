package com.monkmind.digicampus.services.service_impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.Exam;
import com.monkmind.digicampus.repositories.ExamRepository;
import com.monkmind.digicampus.services.ExamService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExamServiceImpl implements ExamService {

	private final ExamRepository examRepository;
	@Override
	public Exam getExamById(Long exam) {
		// TODO Auto-generated method stub
		return examRepository.findById(exam).get();
	}

	@Override
	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}

	
	@Override
	public Exam getById(Exam exam) {
		// TODO Auto-generated method stub
		return examRepository.save(exam);
	}

	@Override
	public List<Exam> listAll() {
		// TODO Auto-generated method stub
		return examRepository.findAll();
	}

	
	
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		 examRepository.deleteById(id);
	}

	

	
}
