package com.invoicems.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.invoicems.models.*;
import com.invoicems.models.Vendor;
import com.invoicems.services.VendorService;


@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    
    
    @PostMapping("/save")
    public ResponseEntity<Vendor> saveOrUpdateVendor(@RequestHeader("customer_id") String customerId, @RequestBody Vendor vendor) {
        try {
        	System.out.println(vendor);
            Vendor savedVendor = vendorService.addVendor(customerId, vendor);
            return new ResponseEntity<>(savedVendor, HttpStatus.CREATED); // Return created vendor with status 201
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // If customer not found, return 404
        }
    }
    
	//--------------------------------------------------------------------
    @GetMapping("/all")
    public List<Vendor> getAllVendors(@RequestHeader("customer_id") String customerId,@RequestParam("type") String type  ) {
    	System.out.println(customerId);
        return vendorService.getAllVendors(customerId,type);
    }
//--------------------------------------------------------------------
    @GetMapping("/{vendorUniqId}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable String vendorUniqId) {
        Optional<Vendor> vendor = vendorService.getVendorById(vendorUniqId);
        return vendor.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }
//--------------------------------------------------------------------
    @PutMapping("/{vendorUniqId}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable String vendorUniqId, @RequestBody Vendor vendorDetails) {
        Vendor updatedVendor = vendorService.updateVendor(vendorUniqId, vendorDetails);
        if (updatedVendor != null) {
            return ResponseEntity.ok(updatedVendor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//--------------------------------------------------------------------
    @DeleteMapping("/{vendorUniqId}")
    public ResponseEntity<String> deleteVendor(@PathVariable String vendorUniqId) {
        vendorService.deleteVendor(vendorUniqId);
        return ResponseEntity.ok("Vendor deleted successfully.");
    }
    
    
//    public ResponseEntity<String>
    
    
    
    
   
   
    
    
    
    
    
    
    
    
    
}
