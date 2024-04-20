package com.nobrokers.nobrokers.service;

import com.nobrokers.nobrokers.entity.User;
import com.nobrokers.nobrokers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        //save the user to the database
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
       return userRepository.findByEmail(email);
    }

    public void verifyEmail(User user) {
        user.setEmailVerified(true);
        userRepository.save(user);
    }

    public boolean isEmailVerified(String email) {
        User user = userRepository.findByEmail(email);
        return user != null && user.isEmailVerified();
    }
}
