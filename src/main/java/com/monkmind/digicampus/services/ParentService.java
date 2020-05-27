package com.monkmind.digicampus.services;

import java.util.List;

import com.monkmind.digicampus.models.NonTeachingStaff;
import com.monkmind.digicampus.models.Parent;
public interface ParentService {
	
	 public Parent getParentByParentId(String parentId);
	    public void save(Parent parent);
	    public Parent get(long parentId); 
	    public List<Parent> listAll();
		public void delete(long id);

}
