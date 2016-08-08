package com.dineshonjava.microservices.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * This web-server works as a microservice client, fetching data from the
 * Web-Service. Uses the Discovery Server (Eureka) to find the microservice.
 * 
 * @author Dinesh Rajput
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class WebServer {

	/**
	 * URL uses the logical name of student-service - upper or lower case,
	 * doesn't matter.
	 */
	public static final String STUDENT_SERVICE_URL = "http://STUDENT-SERVICE";
	
	/**
	 * URL uses the logical name of employee-service - upper or lower case,
	 * doesn't matter.
	 */
	public static final String EMPLOYEE_SERVICE_URL = "http://EMPLOYEE-SERVICE";

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for web-server.properties or web-server.yml
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(WebServer.class, args);
	}

	/**
	 * A customized RestTemplate that has the ribbon load balancer build in.
	 * Note that prior to the "Brixton" 
	 * 
	 * @return
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * The AccountService encapsulates the interaction with the micro-service.
	 * 
	 * @return A new service instance.
	 */
	@Bean
	public WebService webService() {
		return new WebService(STUDENT_SERVICE_URL, EMPLOYEE_SERVICE_URL);
	}

	/**
	 * Create the controller, passing it the {@link WebService} to use.
	 * 
	 * @return
	 */
	@Bean
	public WebController webController() {
		return new WebController(webService());
	}

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
}
