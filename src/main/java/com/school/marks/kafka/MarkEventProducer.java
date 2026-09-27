package com.school.marks.kafka;

import com.school.marks.dto.MarkEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MarkEventProducer {

    private final KafkaTemplate<String , MarkEvent> kafkaTemplate;

    private MarkEventProducer(KafkaTemplate<String, MarkEvent> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMarkEvent(MarkEvent event){
        kafkaTemplate.send("marks-topic",event);
    }
}
