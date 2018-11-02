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
		
		//xpath : https://cleverbuilder.com/articles/camel-choice-when/
		//xpath contains: https://stackoverflow.com/questions/3025885/xpath-1-0-to-find-if-an-elements-value-is-in-a-list-of-values
		from("file:src/main/resources/data?antInclude=*.xml")
		.choice()
			.when(xpath("/products/product[contains ('1 3', accNum)]"))
			.unmarshal(xml)
			.process(new SimpleXMLProcessor())
			.marshal(json)
			.to("jms:queue:productsQueue")
		.end();
		
	}

}
