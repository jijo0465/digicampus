package com.monkmind.digicampus.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.command.ParentCommand;
import com.monkmind.digicampus.converters.ParentCommandToParent;
import com.monkmind.digicampus.converters.ParentToParentCommand;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.models.User;
import com.monkmind.digicampus.models.UserType;
import com.monkmind.digicampus.repositories.ParentRepository;

import lombok.AllArgsConstructor;

/*author:shijina
 created date:15/5/2020
 */

@Service
@AllArgsConstructor
public class ParentServiceImpl implements ParentService {
	
	private final ParentRepository parentRepository;
	private final ParentToParentCommand parentToParentCommand;
	private final ParentCommandToParent parentCommandToParent;
	private final UserService userService;
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

	@Override
	public Parent get(long parentId) {
		// TODO Auto-generated method stub
		return parentRepository.findById(parentId).get();
	}

	@Override
	public List<Parent> listAll() {
		// TODO Auto-generated method stub
		return parentRepository.findAll();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		parentRepository.findById(id);
	}

	@Transactional
	@Override
	public ParentCommand saveParentCommand(ParentCommand parentcommand) {
		// TODO Auto-generated method stub
		Parent detachedParent=parentCommandToParent.convert(parentcommand);
		
		Parent savedParent=parentRepository.save(detachedParent);
		
		//log.debug("saved studentid :"+ savedStudent.getId());
		return parentToParentCommand.convert(savedParent) ;
		
	}

}
