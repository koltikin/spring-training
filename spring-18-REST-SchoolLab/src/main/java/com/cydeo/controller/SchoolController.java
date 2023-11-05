package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.StudentDTO;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class SchoolController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final AddressService addressService;

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

//    @GetMapping("/parents")
//    public ResponseEntity<ResponseWrapper> getAllParents(){
//        return ResponseEntity
//                .status(HttpStatus.ACCEPTED)
//                .header("version","School.v1")
//                .header("operation", "retrieve all parents")
//                .body(new ResponseWrapper("Parents are retrieved successfully",parentService.findAll()));
//
//    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> getAllParents(){
        ResponseWrapper response = new ResponseWrapper(
                true,"parents are successfully retrieved",
                HttpStatus.ACCEPTED, HttpStatus.ACCEPTED.value(),parentService.findAll()
        );
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);

    }


    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAddressById(@PathVariable("id") Long addressId) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("operation","get Address By id")
                .body(new ResponseWrapper("Address retrieved by id", addressService.findById(addressId) ));
    }

    @PutMapping("address/{id}")
    public ResponseEntity<ResponseWrapper> updateAddress(@PathVariable("id") Long addressId,
                                                         @RequestBody AddressDTO addressDTO) throws Exception {
        addressDTO.setId(addressId);
        return ResponseEntity.ok(new ResponseWrapper("address with id "+addressId+" is updated",
                addressService.update(addressDTO)));
    }





}
