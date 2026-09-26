package com.school.marks.service;

import com.school.marks.dto.MarkRequest;
import com.school.marks.entity.Mark;
import com.school.marks.entity.Student;
import com.school.marks.exception.StudentNotFoundException;
import com.school.marks.repository.MarkRepository;
import com.school.marks.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {

    private final MarkRepository markRepository;
    private final StudentRepository studentRepository;

    public MarkService(MarkRepository markRepository,
                       StudentRepository studentRepository){
        this.markRepository = markRepository;
        this.studentRepository = studentRepository;
    }

    public Mark createMark(MarkRequest request){
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new StudentNotFoundException("Student not found for ID: "+ request.getStudentId()));

        Mark mark = new Mark();
        mark.setSubject(request.getSubject());
        mark.setMarks(request.getMarks());
        mark.setStudent(student);

        return markRepository.save(mark);
    }

    public List<Mark> getMarkByStudentId(Long studentId){
        return markRepository.findStudentById(studentId);
    }
}


