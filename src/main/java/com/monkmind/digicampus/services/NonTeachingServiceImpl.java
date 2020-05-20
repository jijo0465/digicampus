package com.monkmind.digicampus.services;

import org.springframework.stereotype.Service;

import com.monkmind.digicampus.models.NonTeachingStaff;
import com.monkmind.digicampus.repositories.NonTeachingRepository;

import lombok.AllArgsConstructor;

/*Anand A B 18/05/2020*/
/*created by:shijina
 * created on:18/05/2020
 */

@Service
@AllArgsConstructor
public class NonTeachingServiceImpl implements NonTeachinService {
	private final NonTeachingRepository nonteachingRepository;

	@Override
	public NonTeachingStaff getById(Long id) {
		// TODO Auto-generated method stub
		return nonteachingRepository.findById(id).get();
	}

	@Override
	public NonTeachingStaff save(NonTeachingStaff nonteachingstaff) {
		// TODO Auto-generated method stub
		return nonteachingRepository.save(nonteachingstaff);
	}
	
	

}
