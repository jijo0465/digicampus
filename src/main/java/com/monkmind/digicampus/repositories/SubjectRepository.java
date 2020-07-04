package com.monkmind.digicampus.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.monkmind.digicampus.models.Period;
import com.monkmind.digicampus.models.Subject;

//Anand A B 18/05/2020

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>{
	
	
	//List<Subject> findByPeriod(Period period);
	List<Subject> findAll();

	
	
}
