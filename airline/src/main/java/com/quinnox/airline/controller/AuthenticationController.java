package com.quinnox.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.airline.dto.AuthenticationDTO;
import com.quinnox.airline.dto.AuthenticationResponse;
import com.quinnox.airline.entity.Authentication;
import com.quinnox.airline.service.AuthenticationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService service;
	
	@PostMapping("/add-login")
	public AuthenticationResponse addLogin(@RequestBody AuthenticationDTO authenticationDTO) {
		
		AuthenticationResponse response = new AuthenticationResponse();
		
		if(service.addLogin(authenticationDTO)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("credentials added");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("credentials not added");
		}
		
		return response;
	}
	
	@GetMapping("/get-login")
	public AuthenticationResponse getLogin() {
		
		AuthenticationResponse response = new AuthenticationResponse();
		
		List<Authentication> authentication = service.getLogin();
		
		if(authentication.size() != 0) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("getting success");
			response.setAuthentication(authentication);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("getting failed");
		}
		return response;
	}
	
	@GetMapping("/login/{email}/{password}")
	public AuthenticationResponse login(@PathVariable("email") String email, @PathVariable("password") String password) {
		
		AuthenticationResponse response = new AuthenticationResponse();
		
		List<Authentication> authentication = service.login(email, password);
		if(authentication.size() != 0) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("login successfully.");
			response.setAuthentication(authentication);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("login Failed");
		}
		return response;
		
	}

}
