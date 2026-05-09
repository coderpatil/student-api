package com.example.demo.service;

import com.example.demo.dto.EnrollmentResponse;
import com.example.demo.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResponse> getAllEnrollment();

    void enrollStudent(int studentId, int courseId);

}
