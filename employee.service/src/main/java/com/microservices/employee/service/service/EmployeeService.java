package com.microservices.employee.service.service;

import com.microservices.employee.service.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author bortnik
 */
@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        this.add(new Employee(1L, 1L, 1L, "John Smith", 34, "Analyst"));
        this.add(new Employee(2L, 1L, 1L, "Darren Hamilton", 37, "Manager"));
        this.add(new Employee(3L, 1L, 1L, "Tom Scott", 26, "Developer"));
        this.add(new Employee(4L, 1L, 2L, "Anna London", 39, "Analyst"));
        this.add(new Employee(5L, 1L, 2L, "Patrick Dempsey", 27, "Developer"));
        this.add(new Employee(6L, 2L, 3L, "Kevin Price", 38, "Developer"));
        this.add(new Employee(7L, 2L, 3L, "Ian Scott", 34, "Developer"));
        this.add(new Employee(8L, 2L, 3L, "Andrew Campton", 30, "Manager"));
        this.add(new Employee(9L, 2L, 4L, "Steve Franklin", 25, "Developer"));
        this.add(new Employee(10L, 2L, 4L, "Elisabeth Smith", 30, "Developer"));
    }

    public Employee add(Employee employee) {
        employee.setId((long) (employees.size()+1));
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        Optional<Employee> employee = employees.stream().filter(a -> a.getId().equals(id)).findFirst();
        return employee.orElse(null);
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return employees.stream().filter(a -> a.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
    }

    public List<Employee> findByOrganization(Long organizationId) {
        return employees.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }

}
