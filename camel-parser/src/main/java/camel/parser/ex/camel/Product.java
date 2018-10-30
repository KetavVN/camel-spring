package camel.parser.ex.camel;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
	
	@XmlAttribute(name = "id")
	private String productId;
	
	@XmlElement(name = "description")
	private String description;
	
	@XmlElement(name = "imageUrl")
	private String imageUrl;
	
	@XmlElement(name = "price")
	private BigDecimal price;
	
	@XmlElement(name = "createdBy")
	private Person createdBy;
	
	public Product(){}
	
	public Product(String productId, String description, String imageUrl,
			BigDecimal price, Person createdBy) {
		this.productId = productId;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return String.format("Product [productId=%s, description=%s, imageUrl=%s, price=%s, createdBy=%s]", productId,
				description, imageUrl, price, createdBy);
	}
	
}
