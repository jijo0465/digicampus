package com.monkmind.digicampus.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Table(name = "person")
public class Person extends BaseEntity{

    private String name;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "is_deleted", columnDefinition = "int default 0")
    private int isDeleted;

    @Lob
    @Column(name = "display_image")
    private byte[] displayImage;

    @JsonFormat(pattern = "dd-MM-yyyy")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }


}
