package com.example.productservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "product_Info")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

        private String description;

        private int price;

        @OneToMany(targetEntity=Product.class, fetch=FetchType.EAGER)
        private List<Product> name;







}
