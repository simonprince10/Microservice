package com.example.demo.service;

import com.example.demo.entity.Inventory;
import com.example.demo.repository.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    InventoryRepo inventoryRepo;

    public Optional<Inventory> getData(Long id) {
        return inventoryRepo.findById(id);
    }

    public String postData(Inventory inventory) {
        Inventory inventory1=new Inventory();
        inventory1.setOrderNo(inventory.getOrderNo());
        inventory1.setDescription(inventory.getDescription());
        inventoryRepo.save(inventory1);
        return "succesfully data inserted";
    }
}
