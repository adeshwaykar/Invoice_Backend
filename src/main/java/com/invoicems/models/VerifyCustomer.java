package com.invoicems.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "verify_customer")

public class VerifyCustomer {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	private String customerEmail;
	private String otp;
	
}
