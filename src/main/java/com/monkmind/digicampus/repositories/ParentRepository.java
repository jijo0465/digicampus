package com.monkmind.digicampus.repositories;

import com.monkmind.digicampus.models.Parent;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ParentRepository extends CrudRepository<Parent,Long> {
	Optional<Parent> findByParentId(String parent);
	Optional<Parent> findById(String parent);
	List<Parent> findAll();

}
