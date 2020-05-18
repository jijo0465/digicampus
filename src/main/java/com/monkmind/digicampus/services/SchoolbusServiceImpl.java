package com.monkmind.digicampus.services;

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
	public void save(SchoolBus schoolbus) {
		// TODO Auto-generated method stub
		schoolbusRepository.save(schoolbus);
	}



	@Override
	public SchoolBus getBusNumber(long busNumber) {
		// TODO Auto-generated method stub
		return schoolbusRepository.findByBusNumber(busNumber).get();
	}

	

}
