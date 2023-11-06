package com.cydeo.controller;

import com.cydeo.dto.AccountDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@Tag(name = "Account",description = "Account CRUD  Operation")
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
//    @Operation(
//            summary = "Create an account",
//            description = "To create an account, use this endpoint",
//            requestBody = @RequestBody(
//                    content = @Content(
//                            mediaType = "application/json",
//                            schema = @Schema(implementation = AccountDTO.class)
//                    )
//            )
//    )
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO){
        System.out.println(accountDTO);
        return ResponseEntity.ok(accountService.save(accountDTO));
    }

}
