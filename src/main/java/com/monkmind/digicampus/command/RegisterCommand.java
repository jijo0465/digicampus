package com.monkmind.digicampus.command;

import java.util.HashSet;
import java.util.Set;

import com.monkmind.digicampus.models.BloodGroup;
import com.monkmind.digicampus.models.Gender;
import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.models.StudentAttendance;
import com.monkmind.digicampus.models.Subject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegisterCommand {

	private long id;
	private String name;
	private String address;
	private String phone;
	private String altPhone;
	private BloodGroup bloodGroup;
	private String dob;
	private Gender gender;
	private Double height;
	private Double weight;
	//private byte[] displayImage;
	private String studentId;
	
	private GradeCommand gradeid;
	
	private Parent parentid;
	
	private SchoolBusCommand schoolBusid;
	private Set<Subject> subjects = new HashSet<>();
	private Set<StudentAttendance> studentAttendance = new HashSet<>();

	
}
