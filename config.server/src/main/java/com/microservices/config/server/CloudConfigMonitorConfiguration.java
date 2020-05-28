package com.microservices.config.server;

import org.springframework.cloud.config.monitor.GithubPropertyPathNotificationExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bortnik
 */
@Configuration
public class CloudConfigMonitorConfiguration {

    @Bean
    public GithubPropertyPathNotificationExtractor githubPropertyPathNotificationExtractor() {
        return new GithubPropertyPathNotificationExtractor();
    }

}
