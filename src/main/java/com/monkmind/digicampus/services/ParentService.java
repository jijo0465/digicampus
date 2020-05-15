package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.Parent;

public interface ParentService {
	
	 public Parent getParentByParentId(String parentId);
	    public void save(Parent parent);


}
