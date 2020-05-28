package com.microservices.employee.service.controller;

import com.microservices.employee.service.model.Employee;
import com.microservices.employee.service.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bortnik
 */
@Slf4j
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/")
    public Employee add(@RequestBody Employee employee) {
        log.info("Employee add: {}", employee);
        return employeeService.add(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        log.info("Employee find: id={}", id);
        return employeeService.findById(id);
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        log.info("Employee find: all");
        return employeeService.findAll();
    }

    @GetMapping("/department/{id}")
    public List<Employee> findByDepartment(@PathVariable("id") Long departmentId) {
        log.info("Employee find: departmentId={}", departmentId);
        return employeeService.findByDepartment(departmentId);
    }

    @GetMapping("/organization/{id}")
    public List<Employee> findByOrganization(@PathVariable("id") Long organizationId) {
        log.info("Employee find: organizationId={}", organizationId);
        return employeeService.findByOrganization(organizationId);
    }
}
