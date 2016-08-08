/**
 * 
 */
package com.dineshonjava.microservices.employee;

import java.util.logging.Logger;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Employee Spring Configuration
 * @author Dinesh.Rajput
 *
 */
@Configuration
@ComponentScan
@EntityScan("com.dineshonjava.microservices.employee")
@EnableJpaRepositories("com.dineshonjava.microservices.employee")
@PropertySource("classpath:employee-db-config.properties")
public class EmployeeConfiguration {
	
	protected Logger logger;

	public EmployeeConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}
}
