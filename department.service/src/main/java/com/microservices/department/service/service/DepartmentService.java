package com.microservices.department.service.service;

import com.microservices.department.service.model.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author bortnik
 */
@Service
public class DepartmentService {

    private final List<Department> departments = new ArrayList<>();

    public DepartmentService() {
        this.create(new Department(1L, "Development", 1L));
        this.create(new Department(2L, "Operations", 1L));
        this.create(new Department(3L, "Development", 2L));
        this.create(new Department(4L, "Operations", 2L));
    }

    public Department create(Department department) {
        department.setId((long) (departments.size()+1));
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        Optional<Department> department = departments.stream().filter(a -> a.getId().equals(id)).findFirst();
        return department.orElse(null);
    }

    public List<Department> findAll() {
        return departments;
    }

    public List<Department> findByOrganization(Long organizationId) {
        return departments.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }

}
