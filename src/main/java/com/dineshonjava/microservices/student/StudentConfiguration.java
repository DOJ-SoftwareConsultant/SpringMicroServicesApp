/**
 * 
 */
package com.dineshonjava.microservices.student;

import java.util.logging.Logger;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Student Spring Configuration
 * @author Dinesh.Rajput
 *
 */
@Configuration
@ComponentScan
@EntityScan("com.dineshonjava.microservices.student")
@EnableJpaRepositories("com.dineshonjava.microservices.student")
@PropertySource("classpath:student-db-config.properties")
public class StudentConfiguration {
	
	protected Logger logger;

	public StudentConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

}
