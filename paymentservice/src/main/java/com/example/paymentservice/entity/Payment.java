package com.example.paymentservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_Info")
public class Payment{

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String status;

    private String orderAmount;
}
