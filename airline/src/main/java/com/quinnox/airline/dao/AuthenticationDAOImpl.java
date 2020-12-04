package com.quinnox.airline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.airline.dto.AuthenticationDTO;
import com.quinnox.airline.entity.Authentication;

@Repository
public class AuthenticationDAOImpl implements AuthenticationDAO{
	
	@Autowired
	private EntityManager manager;

	@Override
	@Transactional
	public boolean addLogin(AuthenticationDTO authenticationDTO) {
		Authentication authentication = new Authentication();
		BeanUtils.copyProperties(authenticationDTO, authentication);
		manager.persist(authentication);
		return true;
	}

	@Override
	public List<Authentication> getLogin() {
		TypedQuery<Authentication> query = manager.createQuery("from Authentication", Authentication.class);
		return query.getResultList();
	}

	@Override
	public List<Authentication> login(String email, String password) {
	   TypedQuery<Authentication> query	= manager.createQuery("select A from Authentication A where A.email=?1 and A.password=?2", Authentication.class);
		query.setParameter(1, email);
		query.setParameter(2, password);
		 
	   return query.getResultList();
	}

}
