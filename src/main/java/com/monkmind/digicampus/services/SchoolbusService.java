package com.monkmind.digicampus.services;


import com.monkmind.digicampus.models.SchoolBus;
import com.monkmind.digicampus.models.Student;

public interface SchoolbusService {

	public SchoolBus getDriverByDriver(String driver);
	 public void save(SchoolBus schoolbus);
	 public SchoolBus getBusNumber(long busNumber); 
}
