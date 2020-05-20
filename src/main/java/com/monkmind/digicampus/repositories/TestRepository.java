package com.monkmind.digicampus.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.Test;

public interface TestRepository extends CrudRepository<Test,Long> {
Optional<Test> findById(String test);
}
