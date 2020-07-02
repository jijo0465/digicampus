package com.monkmind.digicampus.services.serviceImpl;

import com.monkmind.digicampus.models.User;
import com.monkmind.digicampus.repositories.UserRepository;
import com.monkmind.digicampus.services.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByLoginId(String id) {
        return userRepository.findByLoginId(id).orElse(null);
    }
    @Override
    public User saveUser(User user) {
    	return userRepository.save(user);
    }

}
