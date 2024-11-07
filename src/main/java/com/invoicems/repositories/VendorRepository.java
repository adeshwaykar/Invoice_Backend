package com.invoicems.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invoicems.models.Vendor;


@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {
    
}
