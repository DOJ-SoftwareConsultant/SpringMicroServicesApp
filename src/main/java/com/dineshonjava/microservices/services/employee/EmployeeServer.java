/**
 * 
 */
package com.dineshonjava.microservices.services.employee;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.dineshonjava.microservices.employee.EmployeeConfiguration;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link EmployeeConfiguration}. This is a deliberate separation of concerns.
 * @author Dinesh.Rajput
 *
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(EmployeeConfiguration.class)
public class EmployeeServer {
	
	protected Logger logger = Logger.getLogger(EmployeeServer.class.getName());
	
	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for employee-server.properties or
		// employee-server.yml
		System.setProperty("spring.config.name", "employee-server");

		SpringApplication.run(EmployeeServer.class, args);
	}

}
