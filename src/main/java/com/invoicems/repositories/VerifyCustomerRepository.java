package com.invoicems.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.invoicems.models.VerifyCustomer;

public interface VerifyCustomerRepository  extends JpaRepository<VerifyCustomer, Long> {
	
 VerifyCustomer findBycustomerEmail(String customerEmail);

}
