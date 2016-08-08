/**
 * 
 */
package com.dineshonjava.microservices.services.student;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.dineshonjava.microservices.student.StudentConfiguration;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link StudentConfiguration}. This is a deliberate separation of concerns.
 * @author Dinesh.Rajput
 *
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(StudentConfiguration.class)
public class StudentServer {

protected Logger logger = Logger.getLogger(StudentServer.class.getName());
	
	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for student-server.properties or
		// student-server.yml
		System.setProperty("spring.config.name", "student-server");

		SpringApplication.run(StudentServer.class, args);
	}

}
