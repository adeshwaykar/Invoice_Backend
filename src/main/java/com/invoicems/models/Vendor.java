package com.invoicems.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity 
@Table(name = "vendor")
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vendorClientUniqueId;
    private String companyName;
    private Long phone;
    private String email;
    private String gstTreatement;
    private String gstn;
    private String pan;
    private String vat;
    private String website;
    private String contactPerson;
    private Long conatctPhone;
    private String conatctEmail;

    // Foreign key 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_Id")
    @JsonIgnore
    private Customer customer;

    @Embedded
    private Address address;

    
    @ElementCollection
    @CollectionTable(
        name = "vendor_shipping_address",
        joinColumns = @JoinColumn(name = "vendor_vendor_client_unique_id")
    )
    private List<ShippingAddress> shippingAddress = new ArrayList<>();

    private Date createdDate;
    private String type;  // e.g., client, vendor
    private Float openingBalance;
	public String getVendorClientUniqueId() {
		return vendorClientUniqueId;
	}
	public void setVendorClientUniqueId(String vendorClientUniqueId) {
		this.vendorClientUniqueId = vendorClientUniqueId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGstTreatement() {
		return gstTreatement;
	}
	public void setGstTreatement(String gstTreatement) {
		this.gstTreatement = gstTreatement;
	}
	public String getGstn() {
		return gstn;
	}
	public void setGstn(String gstn) {
		this.gstn = gstn;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getVat() {
		return vat;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public Long getConatctPhone() {
		return conatctPhone;
	}
	public void setConatctPhone(Long conatctPhone) {
		this.conatctPhone = conatctPhone;
	}
	public String getConatctEmail() {
		return conatctEmail;
	}
	public void setConatctEmail(String conatctEmail) {
		this.conatctEmail = conatctEmail;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<ShippingAddress> getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(List<ShippingAddress> shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(Float openingBalance) {
		this.openingBalance = openingBalance;
	}

    // Constructors, getters, and setters omitted for brevity
    
}