package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.StudentDTO;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class SchoolController {
    private final TeacherService teacherService;
    private final StudentService studentService;

    @GetMapping("/teachers")
    public List<TeacherDTO> getAllTeachers(){
        List<TeacherDTO> teachers = teacherService.findAll();
        return teachers;
    }
    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> getAllStudents(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("version","api.v1")
                .header("operation","retrieve all students")
                .body(new ResponseWrapper("students are successfully retrieved",
                        studentService.findAll()));

    }
}
