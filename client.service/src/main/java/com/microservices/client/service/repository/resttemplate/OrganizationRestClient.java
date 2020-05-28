package com.microservices.client.service.repository.resttemplate;

import com.microservices.client.service.model.Organization;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author bortnik
 */
@Slf4j
@Component
public class OrganizationRestClient {

    private final CacheManager cacheManager;
    private final RestTemplate template;

    @Autowired
    public OrganizationRestClient(final CacheManager cacheManager,
                                  final RestTemplate template) {
        this.cacheManager = cacheManager;
        this.template = template;
    }

    @CachePut(value = "organizations", key = "#root.methodName")
    @HystrixCommand(fallbackMethod = "findAllFallback")
    public List<Organization> findAll() {
        log.info("Calling a 'findAll' method of organization-service");
        final Organization[] organizations = template.getForObject("http://organization-service/", Organization[].class);
        return ArrayUtils.isNotEmpty(organizations) ? Arrays.asList(organizations) : Collections.emptyList();
    }

    // Implementing a fallback method with cache data
    public List<Organization> findAllFallback() {
        log.info("Calling a 'fallback' method. Retrieving data from cache. Organization service is unavailable");
        return (List<Organization>) Optional.ofNullable(cacheManager.getCache("organizations"))
                .map(cache -> cache.get("findAll"))
                .map(Cache.ValueWrapper::get)
                .orElseGet(Collections::emptyList);
    }


    public Organization findById(final Long id) {
        return template.getForObject("http://organization-service/{id}", Organization.class, id);
    }
}
