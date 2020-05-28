package com.microservices.client.service.repository.feign;

import com.microservices.client.service.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author bortnik
 */
@FeignClient(name = "department-service", fallback = DepartmentFeignClientFallback.class)
public interface DepartmentFeignClient {

    @GetMapping("/organization/{id}")
    List<Department> findByOrganization(@PathVariable("id") Long id);

    @GetMapping("/{id}")
    Department findById(@PathVariable("id") Long id);

}
