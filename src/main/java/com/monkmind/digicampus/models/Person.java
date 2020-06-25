package com.monkmind.digicampus.models;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass

public class Person extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Enumerated(EnumType.STRING)
    private Gender gender;
	
	@Lob
    @Column(name = "display_image")
    private byte[] displayImage;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "blood_group")
    private BloodGroup bloodGroup; 
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "alternate_phone")
	private String altPhone;

	@Column(name = "isDelete")
	private Boolean isDelete=false;

}
