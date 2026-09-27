package com.school.marks.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MarkConsumer {

    @KafkaListener(topics = "marks-topic", groupId = "school-marks-group")
    public void consumerMessage(String message){
        System.out.println("Message received from kafka: "+ message);
    }
}
