package com.example.paymentservice.controller;

import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/getPayment")
    public Optional<Payment> getData(@RequestParam Long id){
        return paymentService.getData(id);
    }

    @PostMapping("/postPayment")
    public String insertData(@RequestBody Payment payment){
        return paymentService.insertData(payment);
    }
}
