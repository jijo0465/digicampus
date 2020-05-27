package com.monkmind.digicampus.services;

import java.util.List;

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
	public Test save(Test test) {
		return testRepository.save(test);
	}


	@Override
	public List<Test> listAll() {
		// TODO Auto-generated method stub
		return testRepository.findAll();
	}


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		testRepository.deleteById(id);
	}

	
	
	

}
