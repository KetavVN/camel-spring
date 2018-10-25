package camel.spring.batch.example.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component("myProcessor")
public class MyProcessor implements Processor {
	
	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println(String.format("csv file content \n %s", exchange.getIn().getBody()));
	}

}
