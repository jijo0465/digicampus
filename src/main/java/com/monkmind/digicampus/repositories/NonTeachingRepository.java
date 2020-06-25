package com.monkmind.digicampus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.monkmind.digicampus.command.NonTeachingStaffCommand;
import com.monkmind.digicampus.models.NonTeachingStaff;

/*Anand A B 18/05/2020*/

public interface NonTeachingRepository extends CrudRepository<NonTeachingStaff,Long> {

	Optional<NonTeachingStaff> findById(long id);
	Optional<NonTeachingStaff> findByStaffId(String staffid);
	List<NonTeachingStaff> findAll();
	//Optional<NonTeachingStaffCommand> findByNonTeachingStaffId(String nonteachingstaff);
	void save(NonTeachingStaffCommand nonTeachingStaffCommand);
	//List<NonTeachingStaffCommand> findAll();
	

}
