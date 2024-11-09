package com.invoicems.repositories;




import org.springframework.data.jpa.repository.JpaRepository;


import com.invoicems.models.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByVerificationOtp(String code);
}
