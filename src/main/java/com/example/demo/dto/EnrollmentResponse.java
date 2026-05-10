package com.example.demo.dto;

import lombok.Getter;

public class EnrollmentResponse {

    @Getter
    private String studentName;

    @Getter
    private String courseName;

    public EnrollmentResponse (String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }



}
