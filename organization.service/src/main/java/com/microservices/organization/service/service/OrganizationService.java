package com.microservices.organization.service.service;

import com.microservices.organization.service.model.Organization;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author bortnik
 */
@Service
public class OrganizationService {

    private final List<Organization> organizations = new ArrayList<>();

    public OrganizationService() {
        this.add(new Organization(1L, "Microsoft", "Redmond, Washington, USA"));
        this.add(new Organization(2L, "Oracle", "Redwood City, California, USA"));
    }

    public Organization add(Organization organization) {
        organization.setId((long) (organizations.size()+1));
        organizations.add(organization);
        return organization;
    }

    public Organization findById(Long id) {
        Optional<Organization> organization = organizations.stream().filter(a -> a.getId().equals(id)).findFirst();
        return organization.orElse(null);
    }

    public List<Organization> findAll() {
        return organizations;
    }

}
