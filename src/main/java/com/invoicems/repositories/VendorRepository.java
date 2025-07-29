package com.invoicems.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invoicems.models.Customer;
import com.invoicems.models.Vendor;


@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {
	
	List<Vendor>findByCustomerAndType(Customer customer,String type);
    
}
