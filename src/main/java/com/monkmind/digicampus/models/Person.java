package com.monkmind.digicampus.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "blood_group")
    private String bloodGroup;

    private String gender;
    private int isDeleted;

    @Lob
    @Column(name = "display_image")
    private byte[] displayImage;


    @Column(name = "is_deleted", columnDefinition = "int default 0")
    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @JsonFormat(pattern = "dd-MM-yyyy")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getDisplayImage() {
        return displayImage;
    }

    public void setDisplayImage(byte[] displayImage) {
        this.displayImage = displayImage;
    }

}
