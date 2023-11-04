package com.cydeo.controller;

import com.cydeo.client.EmployeeClient;
import com.cydeo.client.UserClient;
import com.cydeo.dto.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class Consume_FeignClient {
    private final UserClient userClient;
    private final EmployeeClient employeeClient;
    @GetMapping("/users")
    public ResponseEntity<ResponseWrapper> getAllUsers(){
        return ResponseEntity.ok((new ResponseWrapper("User List Retrieved", userClient.getUsers())));
    }

    @GetMapping("/employee")
    public ResponseEntity<ResponseWrapper> getTenEmployee(){
        return ResponseEntity.ok(new ResponseWrapper("10 Employee retrieved",
                employeeClient.getTenEmployee("6298ebfecd0551211fce37a6")));
    }

}
