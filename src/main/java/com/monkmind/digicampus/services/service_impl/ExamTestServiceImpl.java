package com.monkmind.digicampus.services.service_impl;

import com.monkmind.digicampus.models.ExamTest;
import com.monkmind.digicampus.services.ExamTestService;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ExamTestServiceImpl implements ExamTestService {
	@Override
	public void save(ExamTest examTest) {

	}

//	private final ExamTestRepository examTestRepository;

//	ExamTestServiceImpl(ExamTestRepository examTestRepository){
//		this.examTestRepository = examTestRepository;
//	}
//
//
//	@Override
//	public void save(ExamTest examTest) {
//		examTestRepository.save(examTest);
//	}
}
