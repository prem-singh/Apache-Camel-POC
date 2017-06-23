/**
 * 
 */
package com.camel.sample;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author premsingh
 *
 */
public class SampleProcessor implements Processor {
	
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		User u = in.getBody(User.class);
		System.out.println("In Sample Processor!!! User Object::" +u);
		u.setAge(30);
		String jsonInString = mapper.writeValueAsString(u);
		//System.out.println("After Processing!!! User Object::" +jsonInString);
		in.setBody(jsonInString);
	}

}
