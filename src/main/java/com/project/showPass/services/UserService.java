package com.project.showPass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.showPass.models.User;
import com.project.showPass.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(User user) {
        User userObj = userRepository.save(user);
        return "User added successfully with ID: " + userObj.getUserId();
    }
    
}
