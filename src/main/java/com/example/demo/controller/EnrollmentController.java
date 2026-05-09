package com.example.demo.controller;

import com.example.demo.dto.EnrollmentResponse;
import com.example.demo.model.Enrollment;
import com.example.demo.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping
    public List<EnrollmentResponse> getEnrollments() {
        return enrollmentService.getAllEnrollment();
    }

    @PostMapping
    public String enrollStudent(@RequestParam int studentId,
                                @RequestParam int courseId) {
        enrollmentService.enrollStudent(studentId, courseId);
        return "Student enrolled for the course";
    }

}
