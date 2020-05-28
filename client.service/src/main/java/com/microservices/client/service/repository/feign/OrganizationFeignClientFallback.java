package com.microservices.client.service.repository.feign;

import com.microservices.client.service.model.Organization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author bortnik
 */
@Slf4j
@Component
public class OrganizationFeignClientFallback implements OrganizationFeignClient {

    @Autowired
    private CacheManager cacheManager;

    @Override
    public List<Organization> findAll() {
        log.info("Calling a 'fallback' method. Retrieving data from cache. Organization service is unavailable");
        return (List<Organization>) Optional.ofNullable(cacheManager.getCache("organizations"))
                .map(cache -> cache.get("findAll"))
                .map(Cache.ValueWrapper::get)
                .orElseGet(Collections::emptyList);
    }

    @Override
    public Organization findById(final Long id) {
        log.info("Calling a 'fallback' method for 'findById: {}'. Organization service is unavailable.", id);
        return null;
    }

}
