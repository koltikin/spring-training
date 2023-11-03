package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("version","Cydeo.v3")
                .header("operation","get All Courses")
                .body(new ResponseWrapper("Courses successfully retrieved",courseService.getCourses()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") long courseId){
        return ResponseEntity
                .ok(new ResponseWrapper("course: "+courseId+" retrieved",courseService.getCourseById(courseId)));
    }




}
