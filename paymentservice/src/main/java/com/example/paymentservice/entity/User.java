package com.example.paymentservice.entity;


import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "user_Info")
public class User {
    private String name;
    private String password;
}
