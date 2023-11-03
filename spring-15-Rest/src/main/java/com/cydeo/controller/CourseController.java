package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses/api/v1")
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

    @PostMapping("/create")
    public CourseDTO createCourse(@RequestBody CourseDTO course){
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable("id") long courseId, @RequestBody CourseDTO course){
        courseService.updateCourse(courseId,course);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") long id){
        courseService.deleteCourseById(id);
    }



}
