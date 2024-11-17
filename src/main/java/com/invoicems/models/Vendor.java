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

    // Constructors, getters, and setters omitted for brevity
}