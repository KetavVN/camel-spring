package camel.parser.ex.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class MyJMSRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		// JSON Data Format
		JacksonDataFormat json = new JacksonDataFormat(Products.class);
		
		from("jms:queue:productsQueue")
		.unmarshal(json)
		.bean("productsConsumer","consume");
	}
	
}
