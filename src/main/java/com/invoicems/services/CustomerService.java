package com.invoicems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.invoicems.models.Address;
import com.invoicems.models.Customer;
import com.invoicems.repositories.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmailService emailService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Customer registerCustomer(Customer customer) {
    	
    	return customerRepository.save(customer);
    }

    public boolean verifyCustomer(String otp) {
        Optional<Customer> customer = customerRepository.findByVerificationOtp(otp);
        if (customer.isPresent()) {
            customer.get().setVerified(true);
            customerRepository.save(customer.get());
            return true;
        }
        return false;
    }

    public Optional<Customer> login(String email, String password) {
        System.out.println(email+"  "+password);

        Optional<Customer> customer = customerRepository.findByEmail(email);
        
        if (customer.isPresent()) {
            System.out.println("test by adesh: Customer - " + customer.get() + ", Encoded Password - " + passwordEncoder.encode(customer.get().getPassword()));
        } else {
            System.out.println("Customer not found");
        }
        return customer.filter(value -> passwordEncoder.matches(password, value.getPassword()) );
    }
    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
    public Customer updateCustomer(String id, Customer updatedCustomerData) {
    // Find the existing customer by ID
    Optional<Customer> existingCustomerOptional = customerRepository.findById(id);
    if (existingCustomerOptional.isPresent()) {
        Customer existingCustomer = existingCustomerOptional.get();

        // Update fields only if they are provided (non-null)
        if (updatedCustomerData.getFirstName() != null) {
            existingCustomer.setFirstName(updatedCustomerData.getFirstName());
        }
        if (updatedCustomerData.getLastName() != null) {
            existingCustomer.setLastName(updatedCustomerData.getLastName());
        }
        if (updatedCustomerData.getPhoneNo() != null) {
            existingCustomer.setPhoneNo(updatedCustomerData.getPhoneNo());
        }
        if (updatedCustomerData.getCompanyName() != null) {
            existingCustomer.setCompanyName(updatedCustomerData.getCompanyName());
        }

        // Ensure that the address exists, and initialize if necessary
        if (updatedCustomerData.getAddress() != null) {
            Address updatedAddress = updatedCustomerData.getAddress();

            // Check if the existing customer's address is null and initialize if necessary
            if (existingCustomer.getAddress() == null) {
                existingCustomer.setAddress(new Address());
            }
            Address existingAddress = existingCustomer.getAddress();

            // Update Address fields only if they are provided
            if (updatedAddress.getAddress() != null) {
                existingAddress.setAddress(updatedAddress.getAddress());
            }
            if (updatedAddress.getCity() != null) {
                existingAddress.setCity(updatedAddress.getCity());
            }
            if (updatedAddress.getState() != null) {
                existingAddress.setState(updatedAddress.getState());
            }
            if (updatedAddress.getCountry() != null) {
                existingAddress.setCountry(updatedAddress.getCountry());
            }
            if (updatedAddress.getPincode() != null) {
                existingAddress.setPincode(updatedAddress.getPincode());
            }
        }

        if (updatedCustomerData.getGstinNo() != null) {
            existingCustomer.setGstinNo(updatedCustomerData.getGstinNo());
        }
        if (updatedCustomerData.getTaxNumber() != null) {
            existingCustomer.setTaxNumber(updatedCustomerData.getTaxNumber());
        }
        if (updatedCustomerData.getPassword() != null) {
            existingCustomer.setPassword(passwordEncoder.encode(updatedCustomerData.getPassword()));
        }

        // Save and return the updated customer
        return customerRepository.save(existingCustomer);
    } else {
        throw new EntityNotFoundException("Customer not found with email: ");
    }
}

}
