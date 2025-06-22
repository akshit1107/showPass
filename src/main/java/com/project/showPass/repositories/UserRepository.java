package com.project.showPass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.showPass.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    public User findUserByMobileNumber(String mobileNumber);
    
}