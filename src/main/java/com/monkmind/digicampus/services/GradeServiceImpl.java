package com.monkmind.digicampus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.repositories.GradeRepository;
import com.monkmind.digicampus.repositories.ParentRepository;
import com.monkmind.digicampus.repositories.StudentRepository;

import lombok.AllArgsConstructor;

/*author:shijina
created date:14/5/2020
*/
@Service
@AllArgsConstructor
public class GradeServiceImpl implements GradeService {
  
	private final GradeRepository gradeRepository;
	@Override
	public Grade getGradeByDivision(String division) {
		// TODO Auto-generated method stub
		return gradeRepository.findByDivision(division).get();
	}

	@Override
	public Grade save(Grade grade) {
		return gradeRepository.save(grade);
	}

	@Override
	public Grade getGradeById(Long id) {
		// TODO Auto-generated method stub
		return gradeRepository.findById(id).get();
	}
	
	@Override
	public List<Grade> listAll() {
		// TODO Auto-generated method stub
		return gradeRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		gradeRepository.deleteById(id);
	}

	

}
