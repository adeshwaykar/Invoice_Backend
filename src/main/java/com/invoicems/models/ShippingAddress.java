package com.invoicems.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddress {
    private String shipAddress;
    private String shipCity;
    private String shipCompanyName;
    private String shipCountry;
    private String shipGstin;
    private Long shipPincode;
    private String shipState;
}
