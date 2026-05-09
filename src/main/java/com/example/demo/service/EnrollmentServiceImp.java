package com.example.demo.service;


import com.example.demo.dto.EnrollmentResponse;
import com.example.demo.model.Enrollment;
import com.example.demo.model.Student;
import com.example.demo.model.Course;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EnrollmentServiceImp implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImp(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;


    public List<EnrollmentResponse> getAllEnrollment() {
        return enrollmentRepository.findAll()
                .stream()
                .map(e -> new EnrollmentResponse(
                        e.getStudent().getName(),
                        e.getCourse().getName()
                ))
                .toList();
    }

    @Override
    public void enrollStudent(int studentId, int courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        enrollmentRepository.save(enrollment);
    }
}
