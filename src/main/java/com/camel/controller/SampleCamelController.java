/**
 * 
 */
package com.camel.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author premsingh
 *
 */
@RestController
public class SampleCamelController {

	@Autowired
	ProducerTemplate producerTemplate;

	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String startCamel() throws Exception {
		System.out.println("******************************");
		producerTemplate.sendBody("direct:kimbleservice", "");
		return "Successfully started Camel Router!!";
	}
}
