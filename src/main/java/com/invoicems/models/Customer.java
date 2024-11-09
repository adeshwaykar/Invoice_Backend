package com.invoicems.models;


import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @Column(name = "customer_id", unique = true, nullable = false, length = 32)
    private String customer_id;
  
    @Column(unique = true)
    private String email;

    private String firstName;
    private String lastName;
    private String password;
    private String phoneNo;
    private String companyName;
    private String gstinNo;
    private String taxNumber;
    private String customerLevel;
    private LocalDate createdOn;
    private boolean verified;
    private String verificationOtp;
    //Check customer delete or Active or not 
    private boolean isActive;
    
    @Embedded
   private Address address;
    @Embedded
    private ShippingAddress shippingAddress;
    // Automatically generates a unique 32-character ID before persisting
    @PrePersist
    protected void onCreate() {
        if (this.customer_id == null) {
            this.customer_id = generateUniqueId();
        }
    }

    // Custom method to generate a 32-character unique ID
    private String generateUniqueId() {
        String uuidPart = UUID.randomUUID().toString().replace("-", "").substring(0, 20);
        String timestampPart = Long.toString(System.currentTimeMillis()).substring(0, 12);
        return uuidPart + timestampPart;
    }
   
    
}
