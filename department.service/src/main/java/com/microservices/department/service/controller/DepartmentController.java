package com.microservices.department.service.controller;

import com.microservices.department.service.model.Department;
import com.microservices.department.service.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bortnik
 */
@Slf4j
@RestController
public class DepartmentController {

    @Autowired
    private final DepartmentService departmentService;

    public DepartmentController(final DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/")
    public Department add(@RequestBody Department department) {
        log.info("Department add: {}", department);
        return departmentService.create(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        log.info("Department find: id={}", id);
        return departmentService.findById(id);
    }

    @GetMapping("/")
    public List<Department> findAll() {
        log.info("Department find: all");
        return departmentService.findAll();
    }

    @GetMapping("/organization/{id}")
    public List<Department> findByOrganization(@PathVariable("id") Long organizationId) {
        log.info("Department find: organizationId={}", organizationId);
        return departmentService.findByOrganization(organizationId);
    }

}
