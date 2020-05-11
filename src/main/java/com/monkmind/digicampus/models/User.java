package com.monkmind.digicampus.models;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long uid;

    @Column(unique = true, name = "user_id")
    private String loginId;

    private String password;


}
