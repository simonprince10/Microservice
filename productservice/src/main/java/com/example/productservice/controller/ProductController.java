package com.example.productservice.controller;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.entity.Product;
import com.example.productservice.service.ProdService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    ProdService prodService;

    @GetMapping("/getData")
    public Optional<Product> getData(@RequestParam Long id){
        return prodService.getData(id);
    }

    @PostMapping("/insertData")
    public Product insertData(@RequestBody  Product product)  {
        return prodService.insertData(product);
    }
}
