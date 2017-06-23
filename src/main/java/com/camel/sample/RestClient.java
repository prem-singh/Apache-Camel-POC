/**
 * 
 */
package com.camel.sample;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author premsingh
 *
 */
@Component
public class RestClient {

	@Autowired
	private RestTemplate restTemplate;

	public void postUserDetails(String userJson) {
		// Invoking Rest end point
		URI uri = URI.create("http://localhost:8090/saveuser");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(userJson,headers);
		
		String value =  this.restTemplate.postForObject(uri, entity, String.class);
		
		System.out.println("Returning String from Rest call::::" + value);
	}

}
