package com.quinnox.airline.dto;

import lombok.Data;

@Data
public class AuthenticationDTO {

	private String email;
	
	private String password;
	
	private String role;

}
