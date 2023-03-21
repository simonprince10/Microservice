package com.example.paymentservice.controller;


import com.example.paymentservice.entity.User;
import com.example.paymentservice.event.AuditEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    AuditEventPublisher auditEventPublisher;

    @PostMapping("user")
    public String register(@RequestBody User user){
        auditEventPublisher.publishEvent("user saved successfully with "+user.getName());
        return "user saved successfully";
    }
}
