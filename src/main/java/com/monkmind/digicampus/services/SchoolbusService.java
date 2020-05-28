package com.monkmind.digicampus.services;


import java.util.List;

import com.monkmind.digicampus.command.GradeCommand;
import com.monkmind.digicampus.command.SchoolBusCommand;
import com.monkmind.digicampus.models.SchoolBus;
import com.monkmind.digicampus.models.Student;

public interface SchoolbusService {

	public SchoolBus getDriverByDriver(String driver);
	// public SchoolBus save(SchoolBus schoolbus);
	 public SchoolBus getBusNumber(long busNumber); 
	 public List<SchoolBus> listAll();
	 public void delete(Long busNumber);
	 SchoolBusCommand saveSchoolBusCommand(SchoolBusCommand schoolBusCommand);
}
