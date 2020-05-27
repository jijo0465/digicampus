package com.monkmind.digicampus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.SchoolBus;

import com.monkmind.digicampus.repositories.SchoolbusRepository;

import lombok.AllArgsConstructor;

/*author:shijina
created date:14/5/2020
*/
@Service
@AllArgsConstructor
public class SchoolbusServiceImpl implements SchoolbusService {
	private final SchoolbusRepository schoolbusRepository;

	@Override
	public SchoolBus getDriverByDriver(String driver) {
		// TODO Auto-generated method stub
		return schoolbusRepository.findByDriver(driver).get();
	}

	@Override
	public SchoolBus save(SchoolBus schoolbus) {
		return schoolbusRepository.save(schoolbus);
	}

	 @Override
	 public SchoolBus getBusNumber(long busNumber) {
	// TODO Auto-generated method stub
	 return schoolbusRepository.findByBusNumber(busNumber).get();
	 }

	@Override
	public List<SchoolBus> listAll() {
		// TODO Auto-generated method stub
		return schoolbusRepository.findAll();
	}

	@Override
	public void delete(Long busNumber) {
		// TODO Auto-generated method stub
		schoolbusRepository.deleteByBusNumber(busNumber);
	}

}
