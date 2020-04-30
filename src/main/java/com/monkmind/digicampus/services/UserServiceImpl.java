package com.monkmind.digicampus.services;

import com.monkmind.digicampus.models.User;
import com.monkmind.digicampus.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password).orElse(null);
    }
}
