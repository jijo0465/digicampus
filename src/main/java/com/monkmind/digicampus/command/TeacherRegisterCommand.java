package com.monkmind.digicampus.command;

import java.util.HashSet;
import java.util.Set;

import com.monkmind.digicampus.models.BloodGroup;
import com.monkmind.digicampus.models.Gender;
import com.monkmind.digicampus.models.Subject;
import com.monkmind.digicampus.models.TeacherAttendance;
import com.monkmind.digicampus.models.TeacherTimeTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class TeacherRegisterCommand {

	private long id;
	private String name;
	private String dob;
	private String teacherId;
	private Gender gender;
	private byte[] displayImage;
	private BloodGroup bloodGroup;
	private String address;
	private String phone;
	private String altPhone;
	private GradeCommand grade;
	private Set<Subject> subjects = new HashSet<>();
	private Set<TeacherAttendance> teacherAttendance = new HashSet<>();
	private TeacherTimeTable teacherTimeTable;
}
