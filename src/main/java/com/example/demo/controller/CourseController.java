package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getCourse() {
        return courseService.getAllCourse();
    }

    @PostMapping
    public String addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return "New course added";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return "Course deleted";
    }

}
