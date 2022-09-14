package com.audit.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.entities.User;
import com.audit.exception.ResourceNotFoundException;
import com.audit.repository.UserRepository;
import com.audit.service.UserService;
import com.audit.user.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User saveUser(UserRegistrationDto userRegistrationDto) {
		User user = new User();
		user.setFirstName(userRegistrationDto.getFirstName());
		user.setLastName(userRegistrationDto.getLastName());
		user.setEmailId(userRegistrationDto.getEmailId());
		user.setPassword(userRegistrationDto.getPassword());
		user.setMobileNumber(userRegistrationDto.getMobileNumber());
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}


	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}


	@Override
	public User updateUserById(User user, long id) {
		User existingUser =userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id",id));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmailId(user.getEmailId());
		existingUser.setPassword(user.getPassword());
		existingUser.setMobileNumber(user.getMobileNumber());
		userRepository.save(existingUser);
		return existingUser;
	}


	@Override
	public void deleteUserById(long id) {
		 userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id", id));
		 userRepository.deleteById(id);
	}



	}


