package com.audit.user.dto;



import javax.persistence.Column;


import lombok.*;

@Data
public class UserRegistrationDto {
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobile_number")
	private long mobileNumber;

	
}
