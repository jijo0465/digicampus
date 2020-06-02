package com.monkmind.digicampus.command;

import java.util.HashSet;
import java.util.Set;

import com.monkmind.digicampus.models.BloodGroup;
import com.monkmind.digicampus.models.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ParentCommand {
	
	private long id;
	private String pname;
	private String address;
	private String pphone;
	private String paltPhone;
	private BloodGroup bloodGroup;
	private String dob;
	private Long parentId;
	private String Password;
	private String occupation;
	 Set<RegisterCommand> students = new HashSet<>();

}
