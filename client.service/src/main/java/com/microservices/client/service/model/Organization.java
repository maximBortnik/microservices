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
public class Organization {

    private Long id;
    private String name;
    private String address;
    private List<Department> departments;

    public Organization(final Long id,
                        final String name,
                        final String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
