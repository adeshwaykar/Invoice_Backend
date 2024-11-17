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

    
    public String getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getGstinNo() {
		return gstinNo;
	}


	public void setGstinNo(String gstinNo) {
		this.gstinNo = gstinNo;
	}


	public String getTaxNumber() {
		return taxNumber;
	}


	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}


	public String getCustomerLevel() {
		return customerLevel;
	}


	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}


	public LocalDate getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}


	public boolean isVerified() {
		return verified;
	}


	public void setVerified(boolean verified) {
		this.verified = verified;
	}


	public String getVerificationOtp() {
		return verificationOtp;
	}


	public void setVerificationOtp(String verificationOtp) {
		this.verificationOtp = verificationOtp;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	// Custom method to generate a 32-character unique ID
    private String generateUniqueId() {
        String uuidPart = UUID.randomUUID().toString().replace("-", "").substring(0, 20);
        String timestampPart = Long.toString(System.currentTimeMillis()).substring(0, 12);
        return uuidPart + timestampPart;
    }
   
    
}
