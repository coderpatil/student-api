package com.example.demo.service;

import com.example.demo.model.Student;
import java.util.List;
import org.springframework.data.domain.Page;

public interface StudentService {

    Page<Student> getAllStudents(int page, int size);

    void addStudent(Student student);

    void deleteStudent(int id);
}
