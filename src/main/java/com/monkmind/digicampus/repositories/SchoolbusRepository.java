package com.monkmind.digicampus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.command.SchoolBusCommand;
import com.monkmind.digicampus.models.SchoolBus;


public interface SchoolbusRepository extends CrudRepository<SchoolBus, Long>{

	Optional<SchoolBus> findByDriver(String driver);
	List<SchoolBus> findAll();
	Optional<SchoolBus> findByBusNumber(Long busNumber);
	Optional<SchoolBus>deleteByBusNumber(Long busNumber);
	void save(SchoolBusCommand schoolBuscommand);
	
}
