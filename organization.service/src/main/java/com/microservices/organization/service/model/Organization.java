package com.microservices.organization.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bortnik
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    private Long id;
    private String name;
    private String address;

}
