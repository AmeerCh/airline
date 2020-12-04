package com.quinnox.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.airline.dto.CustomerDTO;
import com.quinnox.airline.dto.CustomerResponse;
import com.quinnox.airline.entity.Customer;
import com.quinnox.airline.service.CustomerService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("/add-customer")
	public CustomerResponse addCustomer(@RequestBody CustomerDTO customerDTO) {
		
		CustomerResponse response = new CustomerResponse();
		
		if(service.addCustomer(customerDTO)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("customer added successfully.");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("customer not added.");
		}
		
		return response;
	}

	
	@GetMapping("/customers")
	public CustomerResponse getAllCustomers() {
		
		CustomerResponse response = new CustomerResponse();
		
		List<Customer> customer = service.getAllCustomers();
		
		if(customer.size() != 0) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Customer details getting succssfully.");
			response.setCustomer(customer);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("Customer details getting failed.");
		}
		return response;
	}
	
	@DeleteMapping("/customer/{customerId}")
	public CustomerResponse deleteCustomer(@PathVariable("customerId") int id) {
		
		CustomerResponse response = new CustomerResponse();
		
		if(service.deleteCustomer(id)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Customer deleted succssfully.");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("Customer deletion failed.");
		}
		
		return response;
	}
	
	@PutMapping("/customer")
	public CustomerResponse updateCustomer(@RequestBody CustomerDTO customerDTO) {
		
		CustomerResponse response = new CustomerResponse();
		
		if(service.updateCustomer(customerDTO)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Customer updated succssfully.");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("Customer updation failed.");
		}
		
		return response;
	}
	
	@GetMapping("/customer/{email}/{password}")
	public CustomerResponse viewProfile(@PathVariable("email") String email, @PathVariable("password") String password) {
		
		CustomerResponse response = new CustomerResponse();
		
		List<Customer> customer = service.viewProfile(email, password);
		if(customer.size() != 0) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("view profile getting successfully");
			response.setCustomer(customer);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("view profile getting failed.");
			
		}
		return response;
	}
}


