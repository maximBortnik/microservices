package com.microservices.client.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bortnik
 */
@RestController
@RefreshScope
public class RefreshController {

    @Value("${sample.string}")
    private String sampleStringProperty;
    @Value("${sample.int}")
    private int sampleIntProperty;

    @GetMapping("/show")
    public String showProperties() {
        return String.format("Hello from %s %d", sampleStringProperty, sampleIntProperty);
    }
}
