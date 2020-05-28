package com.microservices.client.service.repository.feign;

import com.microservices.client.service.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author bortnik
 */
@FeignClient(name = "employee-service")
public interface EmployeeFeignClient {

    @GetMapping("/department/{id}")
    List<Employee> findByDepartment(@PathVariable("id") Long id);

    @GetMapping("/{id}")
    Employee findById(@PathVariable("id") Long id);

}
