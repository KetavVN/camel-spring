package camel.parser.ex.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

@Component
public class MyCSVRoute extends RouteBuilder {

	//option1 works as expected
	/*@Override
	public void configure() throws Exception {
		
		final DataFormat bindy = new BindyCsvDataFormat(Person.class);
		
		from("file:src/main/resources")
			.unmarshal(bindy)
			.process(new SimpleProcessor());
		
	}*/

	//option 2 with custom settings - works as well!
	@Override
	public void configure() throws Exception {
		
		final DataFormat bindy = new BindyCsvDataFormat(Person.class);
		
		final CsvDataFormat csv = new CsvDataFormat();
		csv.setIgnoreEmptyLines(true);
		csv.setDelimiter(",");
		csv.setTrim(true);
		csv.setDataFormat(bindy);
		
		from("file:src/main/resources/data?antInclude=*.csv")
			.unmarshal(csv)
			.process(new SimpleCSVProcessor());
		
	}
	
}
