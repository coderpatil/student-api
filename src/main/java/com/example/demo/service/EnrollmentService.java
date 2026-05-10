package com.example.demo.service;

import com.example.demo.dto.EnrollmentResponse;
import com.example.demo.model.Enrollment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EnrollmentService {
    Page<EnrollmentResponse> getAllEnrollment(int page, int size);

    void enrollStudent(int studentId, int courseId);

}
