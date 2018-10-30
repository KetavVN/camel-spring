package camel.parser.ex.camel;

import org.springframework.stereotype.Service;

@Service("productsConsumer")
public class ProductsConsumer implements Consumer {

	@Override
	public void consume(Products products) {
		System.out.println(products);
	}
	
}
