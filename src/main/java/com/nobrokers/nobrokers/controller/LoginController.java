package com.nobrokers.nobrokers.controller;

import com.nobrokers.nobrokers.service.EmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {
// this is comment

    //thisnis good
    @Autowired
    private EmailVerificationService emailVerificationService;


    //http://localhost:8080/api/send-otp-for-login?email=twilio.send.sms10@gmail.com
    @PostMapping("/send-otp-for-login")
    public Map<String,String> sendOtpForLogin(@RequestParam String email){
        return emailVerificationService.sendOtpForLogin(email);
    }


    //http://localhost:8080/api/verify-otp-for-login?email=twilio.send.sms10@gmail.com&otp=522122
    @PostMapping("/verify-otp-for-login")
    public Map<String, String> verifyOtpForLogin(@RequestParam String email, @RequestParam String otp){
        return emailVerificationService.verifyOtpForLogin(email, otp);
    }
}
