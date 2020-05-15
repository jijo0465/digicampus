package com.monkmind.digicampus.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.mindrot.jbcrypt.BCrypt;

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
@Table(name = "parent")
@Entity

public class Parent extends Person{
	
	@Column(name = "parent_id")
	private Long parentId;
	
	@Column(name = "password")
	private String Password;
	
	@Column(name = "occupation")
	private String occupation;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    Set<Student> students = new HashSet<>();
	
}

