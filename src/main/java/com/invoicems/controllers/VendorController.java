package com.invoicems.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.invoicems.models.Vendor;
import com.invoicems.services.VendorService;


@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/add")
    public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {
        Vendor savedVendor = vendorService.addVendor(vendor);
        return ResponseEntity.ok(savedVendor);
    }
//--------------------------------------------------------------------
    @GetMapping("/all")
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }
//--------------------------------------------------------------------
    @GetMapping("/{companyName}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable String companyName) {
        Optional<Vendor> vendor = vendorService.getVendorById(companyName);
        return vendor.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }
//--------------------------------------------------------------------
    @PutMapping("/{companyName}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable String companyName, @RequestBody Vendor vendorDetails) {
        Vendor updatedVendor = vendorService.updateVendor(companyName, vendorDetails);
        if (updatedVendor != null) {
            return ResponseEntity.ok(updatedVendor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//--------------------------------------------------------------------
    @DeleteMapping("/{companyName}")
    public ResponseEntity<String> deleteVendor(@PathVariable String companyName) {
        vendorService.deleteVendor(companyName);
        return ResponseEntity.ok("Vendor deleted successfully.");
    }
}
