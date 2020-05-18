package com.monkmind.digicampus.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCommand {
    private String loginId;
    private String password;
}
