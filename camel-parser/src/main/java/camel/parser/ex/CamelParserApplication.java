package camel.parser.ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class CamelParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelParserApplication.class, args);
	}
}
