package com.cydeo.controller;

import com.cydeo.dto.AccountDTO;
import com.cydeo.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@Tag(name = "Account0",description = "Account0 CRUD  Operation")
//@Tags(value = {@Tag(name = "Account",description = "Account CRUD  Operation"),
//               @Tag(name = "Account2",description = "Account2 CRUD  Operation")})
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/list")

    @Operation(summary = "Read All the Accounts")
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping
    @Operation(summary = "Read an Accounts by id")
    public ResponseEntity<AccountDTO> getById(@RequestParam("id") Long id) throws Exception {
        return ResponseEntity.ok(accountService.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create an account")
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO){
        return ResponseEntity.ok(accountService.save(accountDTO));
    }

}
