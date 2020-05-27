package com.monkmind.digicampus.command;

import com.monkmind.digicampus.models.BloodGroup;
import com.monkmind.digicampus.models.Gender;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
	private String gradeid;
	private String parentid;
	private String schoolBusid;
	
}
