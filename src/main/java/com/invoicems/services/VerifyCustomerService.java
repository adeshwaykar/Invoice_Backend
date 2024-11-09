package com.invoicems.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicems.models.Customer;
import com.invoicems.models.VerifyCustomer;
import com.invoicems.repositories.VerifyCustomerRepository;

@Service
public class VerifyCustomerService {

	@Autowired
	private VerifyCustomerRepository repository;
	 @Autowired
     private EmailService emailService;
	 @Autowired
	 private CustomerService customerService;
	 

	public VerifyCustomer saveVerifyCustomer(VerifyCustomer customer) {
		 return repository.save(customer);
	}
	
	public VerifyCustomer checkCustomerPresent(String email) {
		
		return repository.findBycustomerEmail(email);
	}
	
	 public VerifyCustomer updateVerifyCustomer(VerifyCustomer customer) {
		 
		 return repository.save(customer);
	 }
	 
	 public boolean deleteVerifyCustomer(VerifyCustomer customer) {
		  repository.delete(customer);
		return true;
	 }
	 
	 
	 public VerifyCustomer updateOrSaveVerifyCustomer(String email) {
		 System.out.println("email "+email);
		String otp= emailService.sendVerificationOtp(email);
		 VerifyCustomer customer=  checkCustomerPresent(email);
		 if(customer!=null) {
			 System.out.println("customer  "+customer);

			 customer.setOtp(otp);
		  return	updateVerifyCustomer(customer);
		 }else {
			 VerifyCustomer saveCustomer=new VerifyCustomer();
			 saveCustomer.setCustomerEmail(email);
			 saveCustomer.setOtp(otp);
			 return saveVerifyCustomer(saveCustomer);
	 }
 }
	 
	 public String checkOtpVerification(VerifyCustomer customer) {
	 		System.out.println(customer);

		 VerifyCustomer verifyCustomer=  checkCustomerPresent(customer.getCustomerEmail());
	 		System.out.println(verifyCustomer);

            if(verifyCustomer!=null) {
            	Optional<Customer> c=null;
            	if(verifyCustomer.getOtp().equals(customer.getOtp())) {
            		deleteVerifyCustomer(verifyCustomer);
            		   
            		 c=customerService.findByEmail(verifyCustomer.getCustomerEmail());
            		if(c.isEmpty()) {
            		  Customer cust=new Customer();          
            		  cust.setEmail(verifyCustomer.getCustomerEmail());
            		  cust.setCreatedOn(LocalDate.now());
            		  cust.setActive(true);
            		return customerService.registerCustomer(cust).getCustomer_id();
            		}else {
            			return c.get().getCustomer_id();
            		}
            	}
            }
		  
		 
		return "";
		 
		 
	 }
	 
}
