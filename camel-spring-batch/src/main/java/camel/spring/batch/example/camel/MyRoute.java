package camel.spring.batch.example.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:/home/ketav/Documents/input/?move=/home/ketav/Documents/workspace/hotels/src/main/resources/")
        .process("myProcessor")
        .to("spring-batch:importUserJob");
    }
}
