package com.monkmind.digicampus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.Period;

public interface PeriodRepository extends CrudRepository<Period,Long>{
	Optional<Period>findById(String Period);
	List<Period> findAll();
	Optional<Period> findById(Long id);
}
