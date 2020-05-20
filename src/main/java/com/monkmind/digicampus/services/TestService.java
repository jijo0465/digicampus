package com.monkmind.digicampus.services;
import com.monkmind.digicampus.models.Test;
//19/05/2020
//haritha
public interface TestService {
	public Test getById(String test);
	void save(Test test);
}
