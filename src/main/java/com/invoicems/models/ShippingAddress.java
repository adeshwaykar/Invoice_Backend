package com.invoicems.models;


public class ShippingAddress {

	private String address1;
	private String country1;
	private String state1;
	private String city1;
	private Long pincode1;
	private String companyName1;
	private String gstin1;
	
	public ShippingAddress() {
		// TODO Auto-generated constructor stub
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCountry1() {
		return country1;
	}

	public void setCountry1(String country1) {
		this.country1 = country1;
	}

	public String getState1() {
		return state1;
	}

	public void setState1(String state1) {
		this.state1 = state1;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public Long getPincode1() {
		return pincode1;
	}

	public void setPincode1(Long pincode1) {
		this.pincode1 = pincode1;
	}

	public String getCompanyName1() {
		return companyName1;
	}

	public void setCompanyName1(String companyName1) {
		this.companyName1 = companyName1;
	}

	public String getGstin1() {
		return gstin1;
	}

	public void setGstin1(String gstin1) {
		this.gstin1 = gstin1;
	}

	@Override
	public String toString() {
		return "ShippingAddress [address1=" + address1 + ", country1=" + country1 + ", state1=" + state1 + ", city1="
				+ city1 + ", pincode1=" + pincode1 + ", companyName1=" + companyName1 + ", gstin1=" + gstin1 + "]";
	}


	
}
