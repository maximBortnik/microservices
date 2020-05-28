package com.microservices.client.service.repository.resttemplate;

import com.microservices.client.service.model.Department;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author bortnik
 */
@Slf4j
@Component
public class DepartmentRestClient {

    private final RestTemplate restTemplate;

    @Autowired
    public DepartmentRestClient(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "findAllFallback")
    public List<Department> findByOrganization(final Long id) {
        log.info("Calling a 'findByOrganization: {}' method of department-service", id);
        final Department[] departments = restTemplate.getForObject("http://department-service/organization/{id}", Department[].class, id);
        return ArrayUtils.isNotEmpty(departments) ? Arrays.asList(departments) : Collections.emptyList();
    }

    // Implementing a fallback method with an empty list
    public List<Department> findAllFallback(final Long id) {
        log.info("Calling a 'fallback' method for 'findByOrganization: {}'. Department service is unavailable.", id);
        return Collections.emptyList();
    }

    public Department findById(final Long id) {
        return restTemplate.getForObject("http://department-service/{id}", Department.class, id);
    }

}
