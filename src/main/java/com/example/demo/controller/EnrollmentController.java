package com.example.demo.controller;

import com.example.demo.dto.EnrollmentResponse;
import com.example.demo.model.Enrollment;
import com.example.demo.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public Page<EnrollmentResponse> getEnrollments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return enrollmentService.getAllEnrollment(page, size);
    }

    @PostMapping
    public String enrollStudent(@Valid @RequestParam int studentId,
                                @RequestParam int courseId) {
        enrollmentService.enrollStudent(studentId, courseId);
        return "Student enrolled for the course";
    }

}
