package com.example.orderservice.controller;

import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderEvent;
import com.example.orderservice.service.OrderService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.OrderComparator;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrder")
    public Optional<Order> getData(@RequestParam Long id){
        return orderService.getData(id);
    }

    @PostMapping("/insertOrder")
    public String insertData(@RequestBody Order order){
        return orderService.insertData(order);
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody Order order) {
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("pending");
        orderEvent.setMessage("order status is in pending state");
        orderService.sendMessage(orderEvent);
        return "order placed successfully...";
    }
}
