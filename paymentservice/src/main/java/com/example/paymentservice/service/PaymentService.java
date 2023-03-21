package com.example.paymentservice.service;

import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepo paymentRepo;

    public Optional<Payment> getData(Long id) {
        return paymentRepo.findById(id);
    }

    public String insertData(Payment payment) {
         paymentRepo.save(payment);
         return "data successfully added";
    }
}
