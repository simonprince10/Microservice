package com.example.productservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String description;
    private String name;
   private int price;
}
