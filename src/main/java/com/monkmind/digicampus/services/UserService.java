package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.User;

public interface UserService {
    public User getUserById(Long id);
    public User getUserByUsername(String username);
    public User getUserByUsernameAndPassword(String username, String password);
}
