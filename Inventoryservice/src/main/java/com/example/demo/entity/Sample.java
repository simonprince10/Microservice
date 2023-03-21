package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "sample_Info")
public class Sample {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private boolean myBoolean = true;
}
