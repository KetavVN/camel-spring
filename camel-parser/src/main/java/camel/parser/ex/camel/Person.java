package camel.parser.ex.camel;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements Serializable {
	
	private static final long serialVersionUID = -4082904203462326077L;

	@DataField(pos = 1)
	@XmlElement(name="fname")
	private String firstName;
	
	@DataField(pos = 2)
	@XmlElement(name="lname")
	private String lastName;
	
	@DataField(pos = 3)
	@XmlElement(name="age")
	private Integer age;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("Person [firstName=%s, lastName=%s, age=%s]", firstName, lastName, age);
	}
	
}
