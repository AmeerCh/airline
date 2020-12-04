package com.quinnox.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.airline.dao.AuthenticationDAO;
import com.quinnox.airline.dto.AuthenticationDTO;
import com.quinnox.airline.entity.Authentication;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	@Autowired
	private AuthenticationDAO dao;
	
	@Override
	public boolean addLogin(AuthenticationDTO authenticationDTO) {
		dao.addLogin(authenticationDTO);
		return true;
	}

	@Override
	public List<Authentication> getLogin() {
		
		return dao.getLogin();
	}

	@Override
	public List<Authentication> login(String email, String password) {
		
		return dao.login(email, password);
	}

}
