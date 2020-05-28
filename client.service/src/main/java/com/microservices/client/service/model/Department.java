package com.microservices.client.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author bortnik
 */
@Data
@NoArgsConstructor
public class Department {

    private Long id;
    private String name;
    private Long organizationId;
    private List<Employee> employees;

    public Department(final Long id,
                      final String name,
                      final Long organizationId) {
        this.id = id;
        this.name = name;
        this.organizationId = organizationId;
    }
}
