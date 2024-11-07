package com.invoicems.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.invoicems.models.Customer;
import com.invoicems.services.CustomerService;
import com.invoicems.services.EmailService;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private EmailService emailService;

    @PostMapping("/signup")
    public String signup(@RequestBody Customer customer) {
        customerService.registerCustomer(customer);
        return "Signup successful! Please verify your email with the OTP.";
    }
 //--------------------------------------------------------------------
    @GetMapping("/verify")
    public String verifyAccount(@RequestParam("otp") String otp) {
        if (customerService.verifyCustomer(otp)) {
            return "Account verified successfully!";
        } else {
            return "Invalid OTP.";
        }
    }
    @PostMapping("/verifyOtp")
    public ResponseEntity<String> verifyOtp(@RequestBody Map<String, String> otpRequest) {
        String otp = otpRequest.get("otp");
        String email = otpRequest.get("email");

        Optional<Customer> customer = customerService.findByEmail(email);

        if (customer.isPresent()) {
            if (otp.equals(customer.get().getVerificationOtp())) {
                customer.get().setVerified(true);  
                customerService.updateCustomerVerification(customer.get());  
                return ResponseEntity.ok("OTP verified successfully!");
            } else {
                return ResponseEntity.status(400).body("Invalid OTP.");
            }
        } else {
            return ResponseEntity.status(404).body("Customer not found.");
        }
    }


//--------------------------------------------------------------------
    
    /*
    @PostMapping("/login")
    public String login(@RequestBody Customer loginRequest) {
        Optional<Customer> customer = customerService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (customer.isPresent()) {
            return "Login successful!";  
        } else {
            return "Invalid credentials or email not verified.";  
        }
    }*/
//--------------------------------------------------------------------
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Customer loginRequest) {
        Optional<Customer> customer = customerService.login(loginRequest.getEmail(), loginRequest.getPassword());
        
        if (customer.isPresent()) {
            
            return ResponseEntity.ok("Login successful!");
        } else {
            
            return ResponseEntity.status(401).body("Invalid credentials or email not verified.");
        }
    }


    
    
}
