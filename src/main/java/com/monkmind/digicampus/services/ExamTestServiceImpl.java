package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.ExamTest;
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
