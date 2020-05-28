package com.microservices.client.service.controller;

import com.microservices.client.service.model.Department;
import com.microservices.client.service.model.Employee;
import com.microservices.client.service.model.Organization;
import com.microservices.client.service.repository.resttemplate.DepartmentRestClient;
import com.microservices.client.service.repository.resttemplate.EmployeeRestClient;
import com.microservices.client.service.repository.resttemplate.OrganizationRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bortnik
 */
@RestController
public class ClientController {

    private final EmployeeRestClient employeeRestClient;
    private final DepartmentRestClient departmentRestClient;
    private final OrganizationRestClient organizationRestClient;

    @Autowired
    public ClientController(final EmployeeRestClient employeeRestClient,
                            final DepartmentRestClient departmentRestClient,
                            final OrganizationRestClient organizationRestClient) {
        this.employeeRestClient = employeeRestClient;
        this.departmentRestClient = departmentRestClient;
        this.organizationRestClient = organizationRestClient;
    }

    @GetMapping("/organizations")
    public List<Organization> findOrganizations() {
        return organizationRestClient.findAll();
    }

    @GetMapping("/organization/{id}")
    public Organization findOrganization(final Long id) {
        final Organization organization = organizationRestClient.findById(id);
        final List<Department> departments = departmentRestClient.findByOrganization(id);
        organization.setDepartments(departments);
        return organization;
    }

    @GetMapping("/department/organization/{id}")
    public List<Department> findDepartmentByOrganization(final Long id) {
        return departmentRestClient.findByOrganization(id);
    }


    @GetMapping("/department/{id}")
    public Department findById(final Long id) {
        final Department department = departmentRestClient.findById(id);
        final List<Employee> employees = employeeRestClient.findByDepartment(id);
        department.setEmployees(employees);
        return department;
    }
}
