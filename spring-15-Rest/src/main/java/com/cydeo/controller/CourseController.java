package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable("id") Long courserId){
        return courseService.getCourseById(courserId);
    }
    @GetMapping("category/{name}")
    public List<CourseDTO> getCoursesByCategory(@PathVariable("name") String category){
        return courseService.getCoursesByCategory(category);

    }
}
