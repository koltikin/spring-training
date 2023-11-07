package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Tag(name = "User",description = "User CRUD operations")
public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    @Operation(summary = "Read all Users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }
    @PostMapping

    @Operation(summary = "Create a User")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDTO));
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a User by id")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long userId) {
        userService.delete(userId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    @Operation(summary = "Read a User by id")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") long userId) {
        return ResponseEntity.ok(userService.findById(userId)) ;
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update a User")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable("id") long userId,
                                                  @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userId,userDTO)) ;
    }

}
