package com.invoicems.repositories;

import com.invoicems.models.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, String> {
  
    // find by hsn
    Items findByHsn(String hsn);
}
