package com.invoicems.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoicems.models.Customer;
import com.invoicems.models.Vendor;
import com.invoicems.repositories.CustomerRepository;
import com.invoicems.repositories.VendorRepository;



@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public Vendor addVendor(Long customerId, Vendor vendor) {
        // Fetch the customer by customerId
        Customer customer = customerRepository.findById(customerId)
                                              .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Associate customer with the vendor
        vendor.setCustomer(customer);

        // Save or update the vendor record
        return vendorRepository.save(vendor);
    }
    
//-------------------------------------------------------------    
    
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    public Optional<Vendor> getVendorById(String companyName) {
        return vendorRepository.findById(companyName);
    }

    public Vendor updateVendor(String companyName, Vendor vendorDetails) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(companyName);
        
        if (vendorOptional.isPresent()) {
            Vendor vendor = vendorOptional.get();
            vendor.setPhone(vendorDetails.getPhone());
            vendor.setEmail(vendorDetails.getEmail());
            vendor.setGstTreatement(vendorDetails.getGstTreatement());
            vendor.setGstn(vendorDetails.getGstn());
            vendor.setPan(vendorDetails.getPan());
            vendor.setVat(vendorDetails.getVat());
            vendor.setWebsite(vendorDetails.getWebsite());
            vendor.setContactPerson(vendorDetails.getContactPerson());
            vendor.setConatctPhone(vendorDetails.getConatctPhone());
            vendor.setConatctEmail(vendorDetails.getConatctEmail());
            vendor.setAddress(vendorDetails.getAddress());
            vendor.setShippingAddress(vendorDetails.getShippingAddress());
            return vendorRepository.save(vendor);
        } else {
            return null;
        }
    }

    public void deleteVendor(String companyName) {
        vendorRepository.deleteById(companyName);
    }
}
