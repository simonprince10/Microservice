package com.example.demo.controller;

import com.example.demo.entity.Inventory;
import com.example.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import java.util.Optional;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/getInventory")
    @RolesAllowed("user")
    public Optional<Inventory> getData(@RequestParam Long id){
        return inventoryService.getData(id);
    }

    @PostMapping("/postInventory")
    public String postData(@RequestBody Inventory inventory){
        return inventoryService.postData(inventory);
    }

}
