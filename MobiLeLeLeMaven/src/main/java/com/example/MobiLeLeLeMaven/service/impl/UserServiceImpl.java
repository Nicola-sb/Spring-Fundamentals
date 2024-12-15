package com.example.MobiLeLeLeMaven.service.impl;

import com.example.MobiLeLeLeMaven.model.UserRegistrationDTO;
import com.example.MobiLeLeLeMaven.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void registerUser(UserRegistrationDTO userRegistration) {
//TODO
        System.out.println("The user received is: " + userRegistration);
    }
}
