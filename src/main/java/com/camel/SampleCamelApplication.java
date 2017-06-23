package com.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author premsingh
 * A sample Spring Boot application that starts the Camel routes.
 */
@SpringBootApplication
public class SampleCamelApplication {
	
	@Bean
	  public RestTemplate rest(RestTemplateBuilder builder) {
	    return builder.build();
	  }

    /**
     * A main method to start this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(SampleCamelApplication.class, args);
    }

}
