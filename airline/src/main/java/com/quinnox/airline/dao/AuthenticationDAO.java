package com.quinnox.airline.dao;

import java.util.List;

import com.quinnox.airline.dto.AuthenticationDTO;
import com.quinnox.airline.entity.Authentication;

public interface AuthenticationDAO {
	
	public boolean addLogin(AuthenticationDTO authenticationDTO);
	
	public List<Authentication> getLogin();
	
	public List<Authentication> login(String email, String password);

}
