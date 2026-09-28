package com.school.marks.service;

import com.school.marks.dto.MarkEvent;
import com.school.marks.entity.Result;
import com.school.marks.repository.ResultRepository;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository){
        this.resultRepository = resultRepository;
    }

    public void ProcessResult(MarkEvent event) {

        String resultStatus;
        if (event.getMarks() >= 40) {
            resultStatus = "PASS";
        } else {
            resultStatus = "FAIL";
        }

        Result result = new Result();

        result.setStudentId(event.getStudentId());
        result.setSubject(event.getSubject());
        result.setMarks(event.getMarks());
        result.setResult(resultStatus);

        // Save result into H2 database
        resultRepository.save(result);

        System.out.println("=====Mark Event Received=====");
        System.out.println("STUDENT ID: " + event.getStudentId());
        System.out.println("SUBJECT: " + event.getSubject());
        System.out.println("MARKS: " + event.getMarks());
        System.out.println("RESULT: "+resultStatus);

        System.out.println("==============================-");
    }
}
