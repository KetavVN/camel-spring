package camel.parser.ex.camel;

import org.springframework.stereotype.Service;

@Service("productsConsumer2")
public class ProductsConsumer2 implements Consumer2 {

	@Override
	public void consume2(String fileName, Long accNum) {
		System.out.println(fileName+" "+accNum);
	}
	
}
