package com.monkmind.digicampus.services;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.repositories.ParentRepository;

import lombok.AllArgsConstructor;

/*author:shijina
 created date:15/5/2020
 */

@Service
@AllArgsConstructor
public class ParentServiceImpl implements ParentService {
	
	private final ParentRepository parentRepository;
	@Override
	public Parent getParentByParentId(String parentId) {
		// TODO Auto-generated method stub
		return parentRepository.findByParentId(parentId).orElse(null);
	}

	@Override
	public void save(Parent parent) {
		// TODO Auto-generated method stub
		parentRepository.save(parent);
		
	}

}
