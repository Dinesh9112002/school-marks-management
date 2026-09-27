package com.school.marks.controller;

import com.school.marks.kafka.MarkProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaTestController {

    private final MarkProducer markProducer;

    public KafkaTestController(MarkProducer markProducer){
        this.markProducer =markProducer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){
        markProducer.sendMessage(message);
        return "Message Sent to Kafka";
    }
}
