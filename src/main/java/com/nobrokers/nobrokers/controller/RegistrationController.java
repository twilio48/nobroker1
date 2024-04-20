package com.nobrokers.nobrokers.controller;

import com.nobrokers.nobrokers.entity.User;
import com.nobrokers.nobrokers.service.EmailService;
import com.nobrokers.nobrokers.service.EmailVerificationService;
import com.nobrokers.nobrokers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    private EmailVerificationService emailVerificationService;

    public RegistrationController(UserService userService, EmailService emailService, EmailVerificationService emailVerificationService) {
        this.userService = userService;
        this.emailService = emailService;
        this.emailVerificationService = emailVerificationService;
    }

    //http://localhost:8080/api/register
    @PostMapping("/register")
    public Map<String, String>   registerUser(@RequestBody User user){
        //Register the user without email verification
        User registeredUser = userService.registerUser(user);
   return emailService.sendOtpEmail(user.getEmail());
    }

//http://localhost:8080/api/verify-otp?email=&otp=
    @PostMapping("/verify-otp")
    public Map<String, String> verifyOtp(@RequestParam String email,  @RequestParam String otp){
       return emailVerificationService.verifyOtp(email, otp);
    }


}
