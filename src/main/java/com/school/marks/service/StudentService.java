package com.school.marks.service;


import com.school.marks.entity.Student;
import com.school.marks.exception.StudentNotFoundException;
import com.school.marks.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() ->
                new StudentNotFoundException("Student not found for ID: " + id));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
