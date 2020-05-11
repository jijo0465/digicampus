package com.monkmind.digicampus.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.mindrot.jbcrypt.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "teacher")
@Entity

public class Teacher extends Person{
	@Column(name = "teacher_id")
	private Long teacherId;
	
	@Column(name = "password")
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	@OneToOne(mappedBy = "classTeacher")
    private Grade grade;
	
	@ManyToMany(mappedBy = "teachers")
    private Set<Subject> subjects = new HashSet<>();
	
	@OneToMany(mappedBy = "teacher")
	private Set<TeacherAttendance> teacherAttendance = new HashSet<>();
	
	@OneToOne(mappedBy = "teacher")
    private TeacherTimeTable teacherTimeTable;
}