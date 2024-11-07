package com.invoicems.services;

import com.invoicems.models.Customer;
import com.invoicems.models.Items;
import com.invoicems.repositories.CustomerRepository;
import com.invoicems.repositories.ItemsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

   
    
 // In the service layer or controller

    public Items saveOrUpdateItem(Long customerId, Items item) {
        Customer customer = customerRepository.findById(customerId)
                                             .orElseThrow(() -> new RuntimeException("Customer not found"));

        item.setCustomer(customer); // Associate customer with the item
        return itemsRepository.save(item); // Save item with associated customer
    }

    

    // Get all 
    public List<Items> getAllItems() {
        return itemsRepository.findAll();
    }

    // Get item by itemName (Pri Key)
    public Optional<Items> getItemByName(String itemName) {
        return itemsRepository.findById(itemName);
    }

    // Delete item by itemName (Pri Key)
    public void deleteItem(String itemName) {
        itemsRepository.deleteById(itemName);
    }

    // Get item by HSN
    public Items getItemByHsn(String hsn) {
        return itemsRepository.findByHsn(hsn);
    }
}
