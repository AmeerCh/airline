package com.quinnox.airline.dto;

import java.util.List;

import com.quinnox.airline.entity.Customer;

import lombok.Data;

@Data
public class CustomerResponse {
	
	private int statusCode;
	
	private String message;
	
	private String description;
	
	private List<Customer> customer;

}
