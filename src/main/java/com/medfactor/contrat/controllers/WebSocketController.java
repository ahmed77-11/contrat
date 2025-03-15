package com.medfactor.contrat.controllers;

import com.medfactor.contrat.dtos.record.TaskEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "task-events")
    public void forwardTaskEvent(ConsumerRecord<String, TaskEvent> record){
        String key=record.key();
        messagingTemplate.convertAndSendToUser(key,"/topic/task-events",record.value());
    }
}
