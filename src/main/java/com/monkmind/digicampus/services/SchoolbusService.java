package com.monkmind.digicampus.services;


import com.monkmind.digicampus.models.SchoolBus;

public interface SchoolbusService {

	public SchoolBus getDriverByDriver(String driver);
	 public void save(SchoolBus schoolbus);
}
