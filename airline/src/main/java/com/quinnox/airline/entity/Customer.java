package com.quinnox.airline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	private String customerName;
	
	private String customerDOB;
	
	private String country;
	
	private String nationality;
	
	private String phoneNumber;
	
	private String address;
	
	private String email;
	
	private String password;
}
