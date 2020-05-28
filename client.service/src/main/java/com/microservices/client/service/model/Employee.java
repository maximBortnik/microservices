package com.microservices.client.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bortnik
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;
    private Long organizationId;
    private Long departmentId;
    private String name;
    private int age;
    private String position;

}
