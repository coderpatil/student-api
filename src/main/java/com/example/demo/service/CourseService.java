package com.example.demo.service;
import com.example.demo.model.Course;
import java.util.*;

public interface CourseService {

    List<Course> getAllCourse();

    void addCourse(Course course);

    void deleteCourse(int id);
}
