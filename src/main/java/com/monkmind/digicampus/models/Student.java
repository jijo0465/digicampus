package com.monkmind.digicampus.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends Person{

    private String registerNumber;
    private Double height;
    private Double weight;
    private String grade;

    @ManyToOne
    private Parent parent;

}
