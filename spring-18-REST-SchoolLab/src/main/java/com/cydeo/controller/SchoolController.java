package com.cydeo.controller;

import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class SchoolController {
    private final TeacherService teacherService;

    @GetMapping("/teachers")
    public List<TeacherDTO> getAllTeachers(){
        List<TeacherDTO> teachers = teacherService.findAll();
        return teachers;
    }
}
