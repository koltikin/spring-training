package com.cydeo.controller;

import com.cydeo.model.Organization;
import com.cydeo.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "/v1/organization")
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/{organizationId}")
    @RolesAllowed({"admin","user"})
    public ResponseEntity<Organization> getOrganization(@PathVariable("organizationId") Long organizationId) throws Exception {
        return ResponseEntity.ok(organizationService.findById(organizationId));
    }

    @PostMapping
    @RolesAllowed({"admin","user"})
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
        return ResponseEntity.status(HttpStatus.CREATED).body(organizationService.create(organization));
    }

    @DeleteMapping("/{organizationId}")
    @RolesAllowed({"admin"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("organizationId") Long organizationId) {
        organizationService.delete(organizationId);
    }

}
