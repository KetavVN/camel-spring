package camel.parser.ex.camel;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Products {

	@XmlElement(name="product")
	List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return String.format("Products [products=%s]", products);
	}
	
}
