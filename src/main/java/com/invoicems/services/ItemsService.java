package com.invoicems.services;

import com.invoicems.models.Customer;
import com.invoicems.models.Items;
import com.invoicems.repositories.CustomerRepository;
import com.invoicems.repositories.ItemsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

   
    
 // In the service layer or controller

    public Items saveOrUpdateItem(String customerId, Items item) {
    	System.out.println(customerId + "    "+item);
        Customer customer = customerRepository.findById(customerId)
                                             .orElseThrow(() -> new RuntimeException("Customer not found"));

        item.setCreatedTime(new Date());
        item.setCustomer(customer); // Associate customer with the item
        
        return itemsRepository.save(item); // Save item with associated customer
    }

    

    // Get all 
    public List<Items> getAllItems(String customerId) {
    	
        Customer customer = customerRepository.findById(customerId)
                                             .orElseThrow(() -> new RuntimeException("Customer not found"));

        return itemsRepository.findByCustomerAndIsDeleted(customer,false);
    }

    // Get item by itemName (Pri Key)
    public Optional<Items> getItemByName(String itemId) {
        return itemsRepository.findById(itemId);
    }

    // Delete item by itemName (Pri Key)
    public void deleteItem(String itemId) {
    	 Optional<Items> item = getItemByName(itemId);
         if (item.isPresent()) {
    	   Items PresentItem=item.get();
    			   PresentItem.setIsDeleted(true);
        itemsRepository.saveAndFlush(PresentItem);
         }
    }

    // Get item by HSN
    public Items getItemByHsn(String hsn) {
        return itemsRepository.findByHsn(hsn);
    }
    
    
    public Items updateItem( Items items,String customerId) {
    	  Customer customer = customerRepository.findById(customerId)
                  .orElseThrow(() -> new RuntimeException("Customer not found"));
    	  items.setCustomer(customer);
    	 return itemsRepository.saveAndFlush(items);
    }
}
