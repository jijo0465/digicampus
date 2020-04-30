package com.monkmind.digicampus.models;

import javax.persistence.Entity;

@Entity
public class Student extends Person{

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    private Long studentId;
}
