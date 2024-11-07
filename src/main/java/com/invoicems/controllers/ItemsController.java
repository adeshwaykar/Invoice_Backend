package com.invoicems.controllers;

import com.invoicems.models.Items;
import com.invoicems.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;
//--------------------------------------------------------------------
    // Create or Update Item
    @PostMapping("/add")
    public ResponseEntity<String> createOrUpdateItem(@RequestBody Items item) {
        itemsService.saveOrUpdateItem(item);
        return ResponseEntity.ok("Item saved/updated successfully!");
    }
//--------------------------------------------------------------------
    // Get all items
    @GetMapping("/all")
    public List<Items> getAllItems() {
        return itemsService.getAllItems();
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
    @DeleteMapping("/{itemName}")
    public ResponseEntity<String> deleteItem(@PathVariable String itemName) {
        Optional<Items> item = itemsService.getItemByName(itemName);
        if (item.isPresent()) {
            itemsService.deleteItem(itemName);
            return ResponseEntity.ok("Item deleted successfully!");
        } else {
            return ResponseEntity.status(404).body("Item not found");
        }
    }
}
