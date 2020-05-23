package com.monkmind.digicampus.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.NonTeachingStaff;

/*Anand A B 18/05/2020*/

public interface NonTeachingRepository extends CrudRepository<NonTeachingStaff,Long> {
	Optional<NonTeachingStaff> findById(String id);
	

}
