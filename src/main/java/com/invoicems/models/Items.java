package com.invoicems.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.invoicems.models.*;

@Entity
@Table(name = "item"
		)
@Data
public class Items {
	
   @Id
   @GeneratedValue(strategy =GenerationType.UUID)
   private String itemId;
   private String itemType; // Product or Service
   
   private String itemName;
   private String description;
   private Integer quantity;
   private String unit;
   private Float tax;
   private String hsn;
   private String sku;
   private String sac;
   private Float saleUnitPrice;
   private String saleCurrency;
   private Float cess;
   private Float cess1;
   private Float percheaseUnitPrice;
   private String percheaseCurrency;
   private Float percheasecess2;
   private Float percheasecess3; 
   private Boolean isDeleted;
   
   private Date createdTime;
   // Foreign key 
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
   @JsonIgnore
   private Customer customer;


public void setPercheaseUnitPrice(Float percheaseUnitPrice) {
	this.percheaseUnitPrice = percheaseUnitPrice;
}

public Items() {
	// TODO Auto-generated constructor stub
   }
   
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public Float getTax() {
	return tax;
}
public void setTax(Float tax) {
	this.tax = tax;
}
public String getHsn() {
	return hsn;
}
public void setHsn(String hsn) {
	this.hsn = hsn;
}
public String getSku() {
	return sku;
}
public void setSku(String sku) {
	this.sku = sku;
}
public Float getSaleUnitPrice() {
	return saleUnitPrice;
}
public void setSaleUnitPrice(Float saleUnitPrice) {
	this.saleUnitPrice = saleUnitPrice;
}
public String getSaleCurrency() {
	return saleCurrency;
}
public void setSaleCurrency(String saleCurrency) {
	this.saleCurrency = saleCurrency;
}
public Float getCess() {
	return cess;
}
public void setCess(Float cess) {
	this.cess = cess;
}
public Float getCess1() {
	return cess1;
}
public void setCess1(Float cess1) {
	this.cess1 = cess1;
}
public Float getPercheaseUnitPrice() {
	return percheaseUnitPrice;
}
public void setPercheaseUnitPrise(Float percheaseUnitPrice) {
	this.percheaseUnitPrice = percheaseUnitPrice;
}
public String getPercheaseCurrency() {
	return percheaseCurrency;
}
public void setPercheaseCurrency(String percheaseCurrency) {
	this.percheaseCurrency = percheaseCurrency;
}

public String getItemId() {
	return itemId;
}

public void setItemId(String itemId) {
	this.itemId = itemId;
}

public String getItemType() {
	return itemType;
}

public void setItemType(String itemType) {
	this.itemType = itemType;
}

public String getSac() {
	return sac;
}

public void setSac(String sac) {
	this.sac = sac;
}

public Float getPercheasecess2() {
	return percheasecess2;
}

public void setPercheasecess2(Float percheasecess2) {
	this.percheasecess2 = percheasecess2;
}

public Float getPercheasecess3() {
	return percheasecess3;
}

public void setPercheasecess3(Float percheasecess3) {
	this.percheasecess3 = percheasecess3;
}

public Boolean getIsDeleted() {
	return isDeleted;
}

public void setIsDeleted(Boolean isDeleted) {
	this.isDeleted = isDeleted;
}

public Date getCreatedTime() {
	return createdTime;
}

public void setCreatedTime(Date createdTime) {
	this.createdTime = createdTime;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}


   
   
	
}
