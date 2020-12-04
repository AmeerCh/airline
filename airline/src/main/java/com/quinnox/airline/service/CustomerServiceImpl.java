package com.quinnox.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.airline.dao.CustomerDAO;
import com.quinnox.airline.dto.CustomerDTO;
import com.quinnox.airline.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDAO dao;

	@Override
	public boolean addCustomer(CustomerDTO customerDTO) {
		dao.addCustomer(customerDTO);
		return true;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return dao.getAllCustomers();
	}

	@Override
	public boolean updateCustomer(CustomerDTO customerDTO) {
		dao.updateCustomer(customerDTO);
		return true;
	}

	@Override
	public boolean deleteCustomer(int id) {
		dao.deleteCustomer(id);
		return true;
	}

	@Override
	public List<Customer> viewProfile(String email, String password) {
	
		return dao.viewProfile(email, password);
	}

}
