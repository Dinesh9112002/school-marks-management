package com.school.marks.kafka;

import com.school.marks.dto.MarkEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MarkEventConsumer {

    @KafkaListener(topics = "marks-topic", groupId = "school-marks-json-group", containerFactory = "markEventKafkaListenerContainerFactory")
    public void consumerMarkEvent(MarkEvent markEvent){
        System.out.println("=====Mark Event Received=====");
        System.out.println("STUDENT ID: "+markEvent.getStudentId());
        System.out.println("SUBJECT: "+markEvent.getSubject());
        System.out.println("MARKS: "+markEvent.getMarks());

        if (markEvent.getMarks() >= 40){
            System.out.println("RESULT: PASS");
        }else {
            System.out.println("RESULT: FAIL");
        }
        System.out.println("==============================-");
    }
}
