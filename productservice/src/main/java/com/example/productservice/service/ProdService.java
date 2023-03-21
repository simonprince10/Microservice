package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProdRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdService {

    @Autowired
    ProdRepo prodRepo;
    public Optional<Product> getData(Long id) {
        return prodRepo.findById(id);
//        return prodRepo.findAll().stream().map(this::insertData).collect(Collectors.toList());
    }

    public Product insertData(Product product) {
        Product product1=new Product();
        product1.setPrice(product.getPrice());
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        return prodRepo.save(product1);
    }
}
