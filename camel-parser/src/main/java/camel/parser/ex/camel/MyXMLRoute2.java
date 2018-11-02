package camel.parser.ex.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyXMLRoute2 extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("file:src/main/resources/data?antInclude=*.xml")
		.choice()
			.when(xpath("/products/product[contains ('1 3', accNum) and contains('product1 product4', description)]"))
			.setHeader("accNum", xpath("/products/product/accNum", Long.class))
			.process(new SimpleCSVProcessor())
			.bean(ProductsConsumer2.class, "consume2(${file:name}, ${headers.accNum})")
		.end();
		
	}

}
