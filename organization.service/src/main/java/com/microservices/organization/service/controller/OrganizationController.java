package com.microservices.organization.service.controller;

import com.microservices.organization.service.model.Organization;
import com.microservices.organization.service.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bortnik
 */
@Slf4j
@RestController
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(final OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    public Organization add(@RequestBody Organization organization) {
        log.info("Organization add: {}", organization);
        return organizationService.add(organization);
    }

    @GetMapping
    public List<Organization> findAll() {
        log.info("Organization find: all");
        return organizationService.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") Long id) {
        log.info("Organization find: id={}", id);
        return organizationService.findById(id);
    }

}
