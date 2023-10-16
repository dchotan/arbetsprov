package com.arbetsprov.stugbokning.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.arbetsprov.stugbokning.model.User;
import com.arbetsprov.stugbokning.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);
	User findUserByEmail(String email);
}
