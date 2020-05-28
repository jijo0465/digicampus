package com.monkmind.digicampus.command;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.monkmind.digicampus.models.BloodGroup;
import com.monkmind.digicampus.models.Gender;
import com.monkmind.digicampus.models.Grade;
import com.monkmind.digicampus.models.Parent;
import com.monkmind.digicampus.models.SchoolBus;
import com.monkmind.digicampus.models.StudentAttendance;
import com.monkmind.digicampus.models.Subject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegisterCommand {

	
	private String name;
	private String address;
	private String phone;
	private String altPhone;
	private BloodGroup bloodGroup;
	private String dob;
	private Gender gender;
	private Double height;
	private Double weight;
	private byte[] displayImage;
	private String studentId;
	//@NotNull
	private Grade gradeid;
	//@NotNull
	private Parent parentid;
	//@NotNull
	private SchoolBus schoolBusid;
	private Set<Subject> subjects = new HashSet<>();
	private Set<StudentAttendance> studentAttendance = new HashSet<>();
	
}
