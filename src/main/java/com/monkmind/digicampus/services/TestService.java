package com.monkmind.digicampus.services;
import java.util.List;

import com.monkmind.digicampus.models.Test;
//19/05/2020
//haritha
public interface TestService {
	public Test getById(Long id);
	 public Test save(Test test);
	 public List<Test> listAll();
	 public void delete(Long id);
}
