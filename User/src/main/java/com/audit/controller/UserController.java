package com.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.entities.User;
import com.audit.service.UserService;
import com.audit.user.dto.UserRegistrationDto;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> saveUser(@RequestBody UserRegistrationDto userRegistrationDto){
		return new ResponseEntity<User>(userService.saveUser(userRegistrationDto),HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}

	@PostMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id){
		return new ResponseEntity<User>(userService.getUserById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUserById(@PathVariable("id") long id,@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUserById(user,id),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") long id){
		 userService.deleteUserById(id);
		 return new ResponseEntity<String>("account deleted successfully!!!",HttpStatus.OK);
}
}