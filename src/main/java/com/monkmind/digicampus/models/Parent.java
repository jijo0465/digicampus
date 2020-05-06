package com.monkmind.digicampus.models;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Parent extends Person{
    private Long parentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    Set<Student> students = new HashSet<>();
}
