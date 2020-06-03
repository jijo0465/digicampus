package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.User;

public interface UserService {
    public User getUserByLoginId(String id);
    public User saveUser(User user);
}
