package com.invoicems.controllers;

import com.invoicems.models.Items;
import com.invoicems.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.invoicems.models.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;
    
    @PostMapping("/createItem")
    public ResponseEntity<Items> saveOrUpdateItem(@RequestHeader("customer_id")String customer_id,  @RequestBody Items item) {
    	System.out.println(customer_id);
        try {
            Items savedItem = itemsService.saveOrUpdateItem(customer_id, item);
        	System.out.println(savedItem);

            return new ResponseEntity<>(savedItem, HttpStatus.CREATED); // Return created item with status 201
        } catch (RuntimeException e) {
        	System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // If customer not found, return 404
        }
    }
//--------------------------------------------------------------------
    // Get all items
  //  @GetMapping("/all")
   // public List<Items> getAllItems() {
     //   return itemsService.getAllItems();
    //}
    
    
    @GetMapping("/all")
    public ResponseEntity<List<Items>> getAllItems(@RequestHeader("customer_id")String customer_id ) {
        List<Items> itemsList = itemsService.getAllItems(customer_id);
        return new ResponseEntity<>(itemsList, HttpStatus.OK);
    }
//--------------------------------------------------------------------

    // Get item by itemName
    @GetMapping("/{itemName}")
    public ResponseEntity<Items> getItemByName(@PathVariable String itemName) {
        Optional<Items> item = itemsService.getItemByName(itemName);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.status(404).body(null); // Item not found
        }
    }
//--------------------------------------------------------------------
    // Get item by HSN
    @GetMapping("/hsn/{hsn}")
    public ResponseEntity<Items> getItemByHsn(@PathVariable String hsn) {
        Items item = itemsService.getItemByHsn(hsn);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.status(404).body(null); // Item not found
        }
    }
//--------------------------------------------------------------------
    // Delete item by itemName
    @DeleteMapping("/{item}/{itemName}")
    public ResponseEntity<String> deleteItem(@PathVariable String itemName) {
        Optional<Items> item = itemsService.getItemByName(itemName);
        if (item.isPresent()) {
            itemsService.deleteItem(itemName);
            return ResponseEntity.ok("Item deleted successfully!");
        } else {
            return ResponseEntity.status(404).body("Item not found");
        }
    }
    
    
    
    @GetMapping("/{item}/{itemId}")
    public ResponseEntity<Items> getItemByItemId(@PathVariable String itemId) {
        Optional<Items> item = itemsService.getItemByName(itemId);
        if (item.isPresent()) {
           
            return new ResponseEntity<>(item.get(),HttpStatus.OK);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
    
    @PatchMapping("/{item}/{itemId}")
    public ResponseEntity<Items> updateItemByItemId(@RequestHeader ("customer_id")String customer_id, @PathVariable String itemId,@RequestBody Items items) {
        Optional<Items> item = itemsService.getItemByName(itemId);
        System.out.println(items);
        System.out.println(itemId);
        System.out.println(customer_id);


        
        if (item.isPresent()) {
        Items upDtaeditem=	itemsService.updateItem(items,customer_id);
           
            return new ResponseEntity<>(upDtaeditem,HttpStatus.OK);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
    
    
    
}
