package com.school.marks.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MarkProducer {

    public final KafkaTemplate<String, String> kafkaTemplate;

    public MarkProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("marks-topic", message);
    }
}
