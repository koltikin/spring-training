package com.cydeo.controller;

import com.cydeo.dto.AccountDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAccounts());
    }
    @GetMapping
    public ResponseEntity<AccountDTO> getById(@RequestParam("id") Long id) throws Exception {
        return ResponseEntity.ok(accountService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAccount(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseWrapper.builder()
                        .message("the account with successfully created")
                        .status(HttpStatus.ACCEPTED)
                        .statusCode(HttpStatus.CREATED.value())
                        .data(accountService.createAccount(accountDTO)).build());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestParam("id") Long id){
        accountService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
