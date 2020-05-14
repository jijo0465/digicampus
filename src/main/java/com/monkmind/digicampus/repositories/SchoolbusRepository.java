package com.monkmind.digicampus.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.models.SchoolBus;



public interface SchoolbusRepository extends CrudRepository<SchoolBus, Long>{

	Optional<SchoolBus> findByDriver(String driver);

	//void save(SchoolBus schoolbus);
}
