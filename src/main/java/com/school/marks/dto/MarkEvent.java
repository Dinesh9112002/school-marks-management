package com.school.marks.dto;


public class MarkEvent {

    private Long studentId;
    private String subject;
    private int marks;

    public MarkEvent(){

    }

    public MarkEvent(Long studentId, String subject, int marks){
        this.studentId = studentId;
        this.subject = subject;
        this.marks = marks;
    }

    public Long getStudentId(){
        return studentId;
    }
    public void setStudentId(Long studentId){
        this.studentId = studentId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
