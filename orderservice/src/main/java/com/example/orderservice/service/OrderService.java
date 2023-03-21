package com.example.orderservice.service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderEvent;
import com.example.orderservice.repository.OrderRepo;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OrderService {


    @Autowired
    OrderRepo orderRepo;

    private static final Logger LOGGER= LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private NewTopic newTopic;

    private KafkaTemplate<String,OrderEvent> kafkaTemplate;

    public OrderService( NewTopic newTopic,KafkaTemplate<String,OrderEvent> kafkaTemplate){
        this.newTopic=newTopic;
        this.kafkaTemplate=kafkaTemplate;
    }

    public Optional<Order> getData(Long id) {
        return orderRepo.findById(id);
    }

    public String insertData(Order order) {
        Order order1=new Order();
        order1.setName(order.getName());
        order1.setOrderNo(order.getOrderNo());
        order1.setPrice(order.getPrice());
        orderRepo.save(order1);
        return "Data inserted Successfully";
    }

    //kafka
    public void sendMessage(OrderEvent orderEvent){
     LOGGER.info(String.format("Order Event => %s",orderEvent.toString()));
        Message<OrderEvent> message=MessageBuilder.withPayload(orderEvent).setHeader(KafkaHeaders.TOPIC,newTopic.name()).build();
        kafkaTemplate.send(message);
    }
}
