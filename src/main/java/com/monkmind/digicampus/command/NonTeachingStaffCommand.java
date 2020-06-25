package com.monkmind.digicampus.command;

import java.util.HashSet;
import java.util.Set;

import com.monkmind.digicampus.models.BloodGroup;
import com.monkmind.digicampus.models.Gender;
import com.monkmind.digicampus.models.NonTStaffAttendance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NonTeachingStaffCommand {

	private long id;
	private String name;
	private String address;
	private String phone;
	private String altPhone;
	private BloodGroup bloodGroup;
	private Gender gender;
	private String dob;
	private String staffId;
	private String category;
	private String designation;
	private Set<NonTStaffAttendance> nonTeachingSA = new HashSet<>();
}
