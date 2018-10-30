package camel.parser.ex.camel;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SimpleCSVProcessor implements Processor {

	@Override @SuppressWarnings("unchecked")
	public void process(Exchange exchange) throws Exception {
		List<Person> list = (List<Person>) exchange.getIn().getBody(List.class);
        for (Person p : list) {
            System.out.println(p);
        }
	}

	/*@Override
	public void process(Exchange exchange) throws Exception {
		Person p = (Person) exchange.getIn().getBody();
		System.out.println(p);
	}*/
	
}
