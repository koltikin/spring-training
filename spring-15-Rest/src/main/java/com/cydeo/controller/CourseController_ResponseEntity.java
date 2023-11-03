package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("version","Cydeo.V2")
                .header("operation","Get list")
                .body(courseService.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") long courseId){
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }
    @GetMapping("/category/{name}")
    public ResponseEntity<List<CourseDTO>> getCoursesByCategory(@PathVariable("name") String categoryName){
        return ResponseEntity.ok(courseService.getCoursesByCategory(categoryName));
    }
    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("operation","Create")
                .body(courseService.createCourse(course));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") long courseId){
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }
@PutMapping("/{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable("id") long courseId, @RequestBody CourseDTO course){
        courseService.updateCourse(courseId,course);
        return ResponseEntity.noContent().build();
    }






}
