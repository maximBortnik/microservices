package com.microservices.department.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bortnik
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private Long id;
    private String name;
    private Long organizationId;

}
