package com.project.showPass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.showPass.models.User;
import com.project.showPass.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public String addUser(User user) {
        User userObj = userRepository.save(user);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Welcome to ShowPass");
        message.setFrom("this.akshit.11@gmail.com");
        message.setTo(userObj.getEmailId());

        String body = "Dear " + userObj.getUserName() + ",\n\n" +
                "Welcome to ShowPass! We are thrilled to have you on board.\n" +
                "Your user ID is: " + userObj.getUserId() + "\n\n" +
                "Best regards,\n" +
                "ShowPass Team";

        message.setText(body);
        javaMailSender.send(message);

        return "User added successfully with ID: " + userObj.getUserId();
    }
    
}
