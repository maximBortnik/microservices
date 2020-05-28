package com.microservices.hystrixdashboard.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

//@EnableTurbine
@EnableTurbineStream
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardServerApplication.class, args);
	}

}
