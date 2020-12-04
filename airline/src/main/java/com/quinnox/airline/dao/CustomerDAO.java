package com.quinnox.airline.dao;

import java.util.List;

import com.quinnox.airline.dto.CustomerDTO;
import com.quinnox.airline.entity.Customer;

public interface CustomerDAO {
	
	public boolean addCustomer(CustomerDTO customerDTO);
	
	public List<Customer> getAllCustomers();
	
	public boolean updateCustomer(CustomerDTO customerDTO);
	
	public boolean deleteCustomer(int id);
	
	public List<Customer> viewProfile(String email, String password);

}
