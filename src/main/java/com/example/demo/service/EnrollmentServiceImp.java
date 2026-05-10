package com.example.demo.service;


import com.example.demo.dto.EnrollmentResponse;
import com.example.demo.model.Enrollment;
import com.example.demo.model.Student;
import com.example.demo.model.Course;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Cacheable(value="enrollments", key="#page + '-' + #size")
    public Page<EnrollmentResponse> getAllEnrollment(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Enrollment> enrollmentsPage = enrollmentRepository.findAll(pageable);

        return enrollmentsPage.map(e -> new EnrollmentResponse(
                e.getStudent().getName(),
                e.getCourse().getName()
        ));
    }

    @Override
    @Transactional
    @CacheEvict(value = "enrollments", allEntries = true)
    public void enrollStudent(int studentId, int courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // check duplicate
        boolean exists = enrollmentRepository
                .existsByStudentIdAndCourseId(studentId, courseId);

        if (exists) {
            throw new RuntimeException("Student already enrolled");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        enrollmentRepository.save(enrollment);
    }
}
