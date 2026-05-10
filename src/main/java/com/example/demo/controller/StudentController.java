package com.example.demo.controller;


import com.example.demo.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.StudentService;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.List;

@RestController
@RestControllerAdvice
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/students")
public class StudentController {

//    private final StudentService studentService;
//
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
    @Autowired
    private StudentService studentService;

    @GetMapping
    public Page<Student> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return studentService.getAllStudents(page, size);
    }

    @PostMapping
    public String addStudent(@Valid @RequestBody Student student) {
        studentService.addStudent(student);
        return "Student added";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "student removed";
    }
}

