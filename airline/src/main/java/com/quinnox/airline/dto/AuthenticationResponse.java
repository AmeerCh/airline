package com.quinnox.airline.dto;

import java.util.List;

import com.quinnox.airline.entity.Authentication;

import lombok.Data;

@Data
public class AuthenticationResponse {
	
	private int statusCode;

	private String message;
	
	private String description;
	
	private List<Authentication> authentication;

}
