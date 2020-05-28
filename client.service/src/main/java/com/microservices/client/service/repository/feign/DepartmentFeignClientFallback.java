package com.microservices.client.service.repository.feign;

import com.microservices.client.service.model.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author bortnik
 */
@Slf4j
@Component
public class DepartmentFeignClientFallback implements DepartmentFeignClient {

    @Override
    public List<Department> findByOrganization(final Long id) {
        log.info("Calling a 'fallback' method for 'findByOrganization: {}'. Department service is unavailable.", id);
        return Collections.emptyList();
    }

    @Override
    public Department findById(final Long id) {
        log.info("Calling a 'fallback' method for 'findById: {}'. Department service is unavailable.", id);
        return null;
    }

}
