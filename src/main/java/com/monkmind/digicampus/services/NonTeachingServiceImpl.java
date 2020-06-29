package com.monkmind.digicampus.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.command.NonTeachingStaffCommand;
import com.monkmind.digicampus.converters.NonTeachingStaffCommandToNonTeachingStaff;
import com.monkmind.digicampus.converters.NonTeachingStaffToNonTeachingStaffCommand;
import com.monkmind.digicampus.models.NonTeachingStaff;
import com.monkmind.digicampus.models.Teacher;
import com.monkmind.digicampus.repositories.NonTeachingRepository;

import lombok.AllArgsConstructor;

/*Anand A B 18/05/2020*/
/*created by:shijina
 * created on:18/05/2020
 */

@Service
@AllArgsConstructor
public class NonTeachingServiceImpl implements NonTeachinService {
	private final NonTeachingRepository nonTeachingRepository;
	private final NonTeachingStaffCommandToNonTeachingStaff nonTeachingStaffCommandToNonTeachingStaff;
	private final NonTeachingStaffToNonTeachingStaffCommand nonTeachingStaffToNonTeachingStaffCommand;

	
	@Override
	public NonTeachingStaff getById(long id) {
		// TODO Auto-generated method stub
		return nonTeachingRepository.findById(id).get();
	}
	@Override
	public NonTeachingStaff save(NonTeachingStaff nonteachingstaff) {
		// TODO Auto-generated method stub
		return nonTeachingRepository.save(nonteachingstaff);
	}

	@Override
	public List<NonTeachingStaff> listAll() {
		// TODO Auto-generated method stub
		return nonTeachingRepository.findAll();
	}

	@Override
	public void delete(long id){
		// TODO Auto-generated method stub
		nonTeachingRepository.deleteById(id);
	}

	
	@Override
	@Transactional
	public NonTeachingStaffCommand saveNonTeachingStaffCommand(NonTeachingStaffCommand staffcommand) {
		// TODO Auto-generated method stub
		NonTeachingStaff detachedNonTEachingStaff=nonTeachingStaffCommandToNonTeachingStaff.convert(staffcommand);
		NonTeachingStaff savedNonTeachingStaff=nonTeachingRepository.save(detachedNonTEachingStaff);
		return nonTeachingStaffToNonTeachingStaffCommand.convert(savedNonTeachingStaff);
		
		
	}
	@Override
	public NonTeachingStaff getNonTeachingStaffByStaffId(String staffid) {
		// TODO Auto-generated method stub
		return nonTeachingRepository.findByStaffId(staffid).orElse(null);
	}
	@Override
	public NonTeachingStaff findById(long id) {
		// TODO Auto-generated method stub
		Optional<NonTeachingStaff> staffoptional=nonTeachingRepository.findById(id);
		return staffoptional.get();
	}

	




	
	

	

}
