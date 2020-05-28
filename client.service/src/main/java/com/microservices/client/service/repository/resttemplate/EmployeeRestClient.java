package com.microservices.client.service.repository.resttemplate;

import com.microservices.client.service.model.Employee;
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
@Component
public class EmployeeRestClient {

    private final RestTemplate template;

    @Autowired
    public EmployeeRestClient(final RestTemplate template) {
        this.template = template;
    }

    public List<Employee> findByDepartment(final Long id) {
        final Employee[] departments = template.getForObject("http://employee-service/department/{id}", Employee[].class, id);
        return ArrayUtils.isNotEmpty(departments) ? Arrays.asList(departments) : Collections.emptyList();
    }

    public Employee findById(final Long id) {
        return template.getForObject("http://employee-service/{id}", Employee.class, id);
    }

}
