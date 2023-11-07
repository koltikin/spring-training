package com.cydeo.controller;

import com.cydeo.dto.AccountDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
@Tag(name = "Account",description = "Account CRUD operations")
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/list")
    @Operation(summary = "Read All Accounts")
    @ApiResponse(responseCode = "200",
                 description = "successful response",
                 content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404",
            description = "Accounts not found",
            content = @Content(mediaType = "application/json"))
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }
    @GetMapping
    @Operation(summary = "Read An Account By Id")
    public ResponseEntity<AccountDTO> getById(@RequestParam("id") Long id) throws Exception {
        return ResponseEntity.ok(accountService.getById(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201",
            description = "successful response",
            content = @Content(mediaType = "application/json"))
    @Operation(summary = "Create an Account")
    public ResponseEntity<ResponseWrapper> createAccount(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseWrapper.builder()
                        .message("new account successfully created")
                        .status(HttpStatus.ACCEPTED)
                        .statusCode(HttpStatus.CREATED.value())
                        .data(accountService.createAccount(accountDTO)).build());
    }

    @DeleteMapping
    @Operation(summary = "Delete an Account")
    public ResponseEntity<Void> deleteById(@RequestParam("id") Long id){
        accountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
