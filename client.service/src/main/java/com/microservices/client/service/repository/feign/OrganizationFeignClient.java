package com.microservices.client.service.repository.feign;

import com.microservices.client.service.model.Organization;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author bortnik
 */
@FeignClient(name = "organization-service")
public interface OrganizationFeignClient {

    @GetMapping("/")
    @CachePut(value = "organizations", key = "#root.methodName")
    List<Organization> findAll();

    @GetMapping("/{id}")
    Organization findById(@PathVariable("id") Long id);

}
