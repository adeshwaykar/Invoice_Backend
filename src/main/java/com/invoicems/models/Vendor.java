package com.invoicems.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "vendor")
public class Vendor {


	@Id
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
	
	@Embedded
	private Address address1;
	
	@Embedded
	private ShippingAddress shippingAddress;
	
	
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Vendor() {
		// TODO Auto-generated constructor stub
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

	public Address getAddress1() {
		return address1;
	}

	public void setAddress1(Address address1) {
		this.address1 = address1;
	}


	@Override
	public String toString() {
		return "Client [companyName=" + companyName + ", phone=" + phone + ", email=" + email + ", gstTreatement="
				+ gstTreatement + ", gstn=" + gstn + ", pan=" + pan + ", vat=" + vat + ", website=" + website
				+ ", contactPerson=" + contactPerson + ", conatctPhone=" + conatctPhone + ", conatctEmail="
				+ conatctEmail + ", address=" + address1 + "]";
	}
	
	
}
