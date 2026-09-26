package com.school.marks.repository;

import com.school.marks.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> findStudentById(Long studentId);
}
