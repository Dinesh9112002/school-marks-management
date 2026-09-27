package com.school.marks.service;

import com.school.marks.dto.MarkEvent;
import com.school.marks.dto.MarkRequest;
import com.school.marks.entity.Mark;
import com.school.marks.entity.Student;
import com.school.marks.exception.StudentNotFoundException;
import com.school.marks.repository.MarkRepository;
import com.school.marks.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.school.marks.kafka.MarkEventProducer;
import java.util.List;

@Service
public class MarkService {

    private final MarkRepository markRepository;
    private final StudentRepository studentRepository;
    private final MarkEventProducer markEventProducer;

    public MarkService(MarkRepository markRepository,
                       StudentRepository studentRepository,
                       MarkEventProducer markEventProducer){
        this.markRepository = markRepository;
        this.studentRepository = studentRepository;
        this.markEventProducer = markEventProducer;
    }

    public Mark createMark(MarkRequest request){
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new StudentNotFoundException("Student not found for ID: "+ request.getStudentId()));

        Mark mark = new Mark();
        mark.setSubject(request.getSubject());
        mark.setMarks(request.getMarks());
        mark.setStudent(student);

        // 1. Save mark into H2
        Mark savedMark = markRepository.save(mark);

        // 2. Create Kafka event
        MarkEvent event = new MarkEvent(student.getId(), mark.getSubject(),mark.getMarks());

        // 3. Send event to Kafka
        markEventProducer.sendMarkEvent(event);
        return savedMark;
    }

    public List<Mark> getMarkByStudentId(Long studentId){
        return markRepository.findStudentById(studentId);
    }
}