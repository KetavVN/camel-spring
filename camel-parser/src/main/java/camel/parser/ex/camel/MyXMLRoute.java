package camel.parser.ex.camel;

import javax.xml.bind.JAXBContext;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.stereotype.Component;

@Component
public class MyXMLRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		JAXBContext context = JAXBContext.newInstance(Products.class);
		
		JaxbDataFormat xml = new JaxbDataFormat("camel.parser.ex.camel");
		xml.setContext(context);
		xml.setEncoding("UTF-8");
		xml.setContentTypeHeader(true);
		
		// JSON Data Format
		JacksonDataFormat json = new JacksonDataFormat(Products.class);
		
		from("file:src/main/resources/data?antInclude=*.xml")
		.unmarshal(xml)
		.process(new SimpleXMLProcessor())
		.marshal(json)
		.to("jms:queue:productsQueue");
	}

}
