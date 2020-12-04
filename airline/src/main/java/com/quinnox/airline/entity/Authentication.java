package com.quinnox.airline.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Authentication {

	@Id
	private String email;
	
	private String password;
	
	private String role;

}
