package com.example.orderservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_Info")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String price;

    private  String orderNo;

}
