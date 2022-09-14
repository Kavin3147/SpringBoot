package com.audit.service;

import java.util.List;

//import org.springframework.security.core.userdetails.UserDetailsService;

import com.audit.entities.User;
import com.audit.user.dto.UserRegistrationDto;

public interface UserService{

	User saveUser(UserRegistrationDto userRegistrationDto);
	public List<User> getAllUser();
	User getUserById(long id);
	User updateUserById(User user,long id);
	void deleteUserById(long id);

}
