package com.school.marks.kafka;

import com.school.marks.dto.MarkEvent;
import com.school.marks.service.ResultService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MarkEventConsumer {

    private final ResultService resultService;

    public MarkEventConsumer(ResultService resultService) {
        this.resultService = resultService;
    }

    @KafkaListener(topics = "marks-topic", groupId = "school-marks-json-group", containerFactory = "markEventKafkaListenerContainerFactory")
    public void consumerMarkEvent(MarkEvent markEvent) {
        System.out.println("=====KAFKA Event Received=====");
        resultService.ProcessResult(markEvent);
        System.out.println("==============================");
    }
}
