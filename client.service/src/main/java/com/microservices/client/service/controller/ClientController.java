package com.microservices.client.service.controller;

import com.microservices.client.service.model.Department;
import com.microservices.client.service.model.Employee;
import com.microservices.client.service.model.Organization;
import com.microservices.client.service.repository.feign.DepartmentFeignClient;
import com.microservices.client.service.repository.feign.EmployeeFeignClient;
import com.microservices.client.service.repository.feign.OrganizationFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bortnik
 */
@RestController
public class ClientController {

//    private final EmployeeRestClient employeeClient;
//    private final DepartmentRestClient departmentClient;
//    private final OrganizationRestClient organizationClient;
//
//    @Autowired
//    public ClientController(final EmployeeRestClient employeeClient,
//                            final DepartmentRestClient departmentClient,
//                            final OrganizationRestClient organizationClient) {
//        this.employeeClient = employeeClient;
//        this.departmentClient = departmentClient;
//        this.organizationClient = organizationClient;
//    }

    private final DepartmentFeignClient departmentClient;
    private final EmployeeFeignClient employeeClient;
    private final OrganizationFeignClient organizationClient;

    @Autowired
    public ClientController(final DepartmentFeignClient departmentClient,
                            final EmployeeFeignClient employeeClient,
                            final OrganizationFeignClient organizationClient) {
        this.departmentClient = departmentClient;
        this.employeeClient = employeeClient;
        this.organizationClient = organizationClient;
    }

    @GetMapping("/organizations")
    public List<Organization> findOrganizations() {
        return organizationClient.findAll();
    }

    @GetMapping("/organization/{id}")
    public Organization findOrganization(final Long id) {
        final Organization organization = organizationClient.findById(id);
        final List<Department> departments = departmentClient.findByOrganization(id);
        organization.setDepartments(departments);
        return organization;
    }

    @GetMapping("/department/organization/{id}")
    public List<Department> findDepartmentByOrganization(final Long id) {
        return departmentClient.findByOrganization(id);
    }


    @GetMapping("/department/{id}")
    public Department findById(final Long id) {
        final Department department = departmentClient.findById(id);
        final List<Employee> employees = employeeClient.findByDepartment(id);
        department.setEmployees(employees);
        return department;
    }
}
