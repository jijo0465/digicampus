package com.monkmind.digicampus.services.service_impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.command.SchoolBusCommand;
import com.monkmind.digicampus.converters.SchoolBusCommandToSchoolBus;
import com.monkmind.digicampus.converters.SchoolBusToSchoolBusCommand;
import com.monkmind.digicampus.models.SchoolBus;

import com.monkmind.digicampus.repositories.SchoolbusRepository;
import com.monkmind.digicampus.services.SchoolbusService;

import lombok.AllArgsConstructor;

/*author:shijina
created date:14/5/2020
*/
@Service
@AllArgsConstructor
public class SchoolbusServiceImpl implements SchoolbusService {
	private final SchoolbusRepository schoolbusRepository;
	private final SchoolBusCommandToSchoolBus schoolBusCommandToSchoolBus;
	private final SchoolBusToSchoolBusCommand schoolBusToSchoolBusCommand;
	

	@Override
	public SchoolBus getDriverByDriver(String driver) {
		// TODO Auto-generated method stub
		return schoolbusRepository.findByDriver(driver).get();
	}

	/*@Override
	public SchoolBus save(SchoolBus schoolbus) {
		return schoolbusRepository.save(schoolbus);
	}
	*/

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

	@Override
	@Transactional
	public SchoolBusCommand saveSchoolBusCommand(SchoolBusCommand schoolBusCommand) {
		// TODO Auto-generated method stub
		
		SchoolBus detachedSchoolBus=schoolBusCommandToSchoolBus.convert(schoolBusCommand);
		SchoolBus savedSchoolBus=schoolbusRepository.save(detachedSchoolBus);
		//log.debug("saved studentid :"+ savedStudent.getId());
		return schoolBusToSchoolBusCommand.convert(savedSchoolBus) ;
	}

}
