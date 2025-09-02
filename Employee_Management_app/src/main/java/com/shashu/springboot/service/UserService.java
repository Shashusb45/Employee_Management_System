package com.shashu.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.shashu.springboot.dto.UserRegistrationDto;
import com.shashu.springboot.model.User;


public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
