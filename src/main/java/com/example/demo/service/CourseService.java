package com.example.demo.service;
import com.example.demo.model.Course;
import org.springframework.data.domain.Page;

import java.util.*;

public interface CourseService {

    Page<Course> getAllCourse(int page, int size);

    void addCourse(Course course);

    void deleteCourse(int id);
}
