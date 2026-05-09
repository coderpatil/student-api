package com.example.demo.service;


import java.util.*;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImp implements CourseService{

    private final CourseRepository courseRepository;

    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

}
