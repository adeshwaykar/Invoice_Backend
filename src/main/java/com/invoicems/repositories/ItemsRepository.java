package com.invoicems.repositories;

import com.invoicems.models.Customer;
import com.invoicems.models.Items;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, String> {
  
    // find by hsn
    Items findByHsn(String hsn);
    
    List<Items>findByCustomerAndIsDeleted(Customer customer,Boolean isDeleted);
}
