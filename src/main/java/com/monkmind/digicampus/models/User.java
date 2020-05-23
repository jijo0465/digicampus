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
public class User extends BaseEntity{
    @Column(unique = true, name = "login_id")
    private String loginId;
    private String password;
  @Enumerated(EnumType.STRING)
    private UserType usertype;
}
