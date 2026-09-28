package com.school.marks.controller;

import com.school.marks.dto.MarkRequest;
import com.school.marks.entity.Mark;
import com.school.marks.service.MarkService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarkController {

    private final MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @PostMapping
    public Mark createMark(@Valid @RequestBody MarkRequest markRequest) {
        return markService.createMark(markRequest);
    }

    @GetMapping("/student/{studentId}")
    public List<Mark> getMarksByStudentId(@PathVariable Long studentId) {
        return markService.getMarkByStudentId(studentId);
    }
}
