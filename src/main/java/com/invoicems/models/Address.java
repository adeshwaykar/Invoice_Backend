package com.invoicems.models;

public class Address {

	private String address;
	private String country;
	private String state;
	private String city;
	private Long pincode;
	private String faceBookNo;
	private String dlNO;
	private String notes;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	public String getFaceBookNo() {
		return faceBookNo;
	}
	public void setFaceBookNo(String faceBookNo) {
		this.faceBookNo = faceBookNo;
	}
	public String getDlNO() {
		return dlNO;
	}
	public void setDlNO(String dlNO) {
		this.dlNO = dlNO;
	}
	@Override
	public String toString() {
		return "Address [address=" + address + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", pincode=" + pincode + ", faceBookNo=" + faceBookNo + ", dlNO=" + dlNO + ", notes=" + notes + "]";
	}
	
	
}
