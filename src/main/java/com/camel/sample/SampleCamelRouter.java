package com.camel.sample;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class SampleCamelRouter extends RouteBuilder {
	
	@Autowired
	private SampleInterface sample;

    @Override
    public void configure() throws Exception {
      // option-1
    /* from("timer:kimbleservice?period={{timer.period}}")
        .bean(sample.getClass(),"getUser()")
        .process(new Processor() {
			@Override
			public void process(Exchange exchange) {
   			 Message in = exchange.getIn();
   			 User u=in.getBody(User.class);
   			 u.setAge(30);
   			 in.setBody(u);
   		 }
		})
        .log("User Object==> ${body}");
        */
    	//options-2
    	/*from("direct:kimbleservice")
        .bean(sample.getClass(),"getUser()")
        .process(new Processor() {
			@Override
			public void process(Exchange exchange) {
   			 Message in = exchange.getIn();
   			 User u=in.getBody(User.class);
   			 u.setAge(30);
   			 in.setBody(u);
   		 }
		})
        .log("User Object==> ${body}");
        */
    	//With Custom Processor and publish to rest end point
    	from("timer:kimbleservice?period={{timer.period}}")
    	.id("kimbleservice-router")
        .bean(sample.getClass(),"getUser()")
        .process(new SampleProcessor() )
        .log("User Object==> ${body}")
    	.to("class:com.camel.sample.RestClient?method=postUserDetails");
    	
    	/*from("timer:kimbleservice?period={{timer.period}}")
    	.id("kimbleservice-router")
    	 .bean(sample.getClass(),"getUser()")
    	 .process(new SampleProcessor() )
    	 .log("User Object==> ${body}")
        .setHeader(Exchange.HTTP_METHOD).constant("POST")
        .setHeader(Exchange.CONTENT_TYPE).constant("application/json")
        .to("http://localhost:8090/saveuser").convertBodyTo(String.class)
        .to("log:query result from rest api-${body}");
        */
    }
}
