package com.school.marks.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MarkRequest {

    @NotNull(message = "ID should not be null")
    private Long studentId;

    @NotBlank(message = "Enter Subject")
    private String subject;

    @Min(value = 0, message = "Marks cannot be less than 0")
    @Max(value = 100, message = "Marks cannot be more than 100")
    private int marks;

    public Long getStudentId(){
        return studentId;
    }

    public void setStudentId(Long id){
        this.studentId =id;
    }

    public  String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public int getMarks(){
        return marks;
    }

    public void setMarks(int marks){
        this.marks = marks;
    }
}
