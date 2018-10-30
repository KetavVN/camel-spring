package camel.parser.ex.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SimpleXMLProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Products list = exchange.getIn().getBody(Products.class);
        for (Product p : list.getProducts()) {
            System.out.println(p);
        }
	}

}
