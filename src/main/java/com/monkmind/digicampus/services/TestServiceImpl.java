package com.monkmind.digicampus.services;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.Test;
import com.monkmind.digicampus.repositories.TestRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService{
	private final TestRepository testRepository;
	
	
	@Override
	public Test getById(Long id) {
		// TODO Auto-generated method stub
		return testRepository.findById(id).get();
	}	
	

	@Override
	public void save(Test test) {
		// TODO Auto-generated method stub
		 testRepository.save(test);
	}

	
	
	

}
