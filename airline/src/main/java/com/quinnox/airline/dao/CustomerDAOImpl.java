package com.quinnox.airline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.airline.dto.CustomerDTO;
import com.quinnox.airline.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
	private EntityManager manager;

	@Override
	@Transactional
	public boolean addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		manager.persist(customer);
		return true;
	}

	@Override
	public List<Customer> getAllCustomers() {
		TypedQuery<Customer> query = manager.createQuery("from Customer", Customer.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public boolean updateCustomer(CustomerDTO customerDTO) {
		
		Customer customer = manager.find(Customer.class, customerDTO.getCustomerId());
		BeanUtils.copyProperties(customerDTO, customer);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteCustomer(int id) {
		Customer customer = manager.find(Customer.class, id);
		manager.remove(customer);
		return true;
	}

	@Override
	public List<Customer> viewProfile(String email, String password) {
		TypedQuery<Customer> query = manager.createQuery("select C from Customer C where C.email=?1 and C.password=?2", Customer.class);
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		return query.getResultList();
	}

}
