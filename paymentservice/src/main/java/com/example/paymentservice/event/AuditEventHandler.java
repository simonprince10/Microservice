package com.example.paymentservice.event;

import com.example.paymentservice.entity.LogData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AuditEventHandler {

    @SneakyThrows
    @Async
    @EventListener
    public void handleEvent(AuditEvent<LogData> auditEvent){
        System.out.println(new ObjectMapper().
                writerWithDefaultPrettyPrinter().
                writeValueAsString(auditEvent.getData()));
    }
}

