package com.school.marks.controller;

import com.school.marks.entity.Result;
import com.school.marks.repository.ResultRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultRepository resultRepository;

    public ResultController(ResultRepository resultRepository){
        this.resultRepository = resultRepository;
    }

    @GetMapping
    public List<Result> getAllResults(){
        return resultRepository.findAll();
    }
}
