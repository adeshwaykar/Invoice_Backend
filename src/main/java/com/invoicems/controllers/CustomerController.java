package com.invoicems.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.invoicems.models.Customer;
import com.invoicems.models.VerifyCustomer;
import com.invoicems.services.CustomerService;
import com.invoicems.services.EmailService;
import com.invoicems.services.VerifyCustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private VerifyCustomerService verifyCustomerService;

    @PutMapping("/signup")
    @CrossOrigin(origins = "http://localhost:3000") // Update with your frontend URL
    public String signup(@RequestBody Customer customer) {
        customerService.updateCustomer(customer.getCustomer_id(), customer);
        return "signup done";
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
    @CrossOrigin(origins = "http://localhost:3000") // Update with your frontend URL

    public ResponseEntity<String> verifyOtp(@RequestBody Map<String, String> otpRequest) {
      
        VerifyCustomer  emailOtp=new VerifyCustomer();
        emailOtp.setCustomerEmail(otpRequest.get("email"));
        emailOtp.setOtp(otpRequest.get("otp"));

       String presentOrNot= verifyCustomerService.checkOtpVerification(emailOtp);
               System.out.println(presentOrNot +"test by adesh");
        if(presentOrNot!="") {
            return ResponseEntity.ok(presentOrNot);

        }else {
            return ResponseEntity.status(401).body("otp not match");

        }

//        if (customer.isPresent()) {
//            if (otp.equals(customer.get().getVerificationOtp())) {
//                customer.get().setVerified(true);  
//                customerService.updateCustomerVerification(customer.get());  
//                return ResponseEntity.ok("OTP verified successfully!");
//            } else {
//                return ResponseEntity.status(400).body("Invalid OTP.");
//            }
//        } else {
//            return ResponseEntity.status(404).body("Customer not found.");
//        }
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
    @CrossOrigin(origins = "http://localhost:3000") // Update with your frontend URL

    public ResponseEntity<String> login(@RequestBody Customer loginRequest) {
       // System.out.println(loginRequest.getEmail());

        Optional<Customer> customer = customerService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (customer.isPresent()) {
            
            return ResponseEntity.ok(customer.get().getCustomer_id());
        } else {
            
            return ResponseEntity.status(401).body("Invalid credentials or email not verified.");
        }
    }
    
    
    @PostMapping("/sendOtp")
    @CrossOrigin(origins = "http://localhost:3000") // Update with your frontend URL
    public ResponseEntity<String>sendOtp(@RequestParam String email){
    	
    	VerifyCustomer customer= verifyCustomerService.updateOrSaveVerifyCustomer(email);
    	   System.out.println("d"+customer);
    	if(customer!=null) {
    		return ResponseEntity.ok("send email");
    	}
		return ResponseEntity.status(401).body("Something get wrong"); 
    	
    }


    
    
}
