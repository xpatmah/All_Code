package som.org.soapservice.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private  String sname= "";
	
	private String owner ="";
	
	private String price = "";

	public Product() {
		super();
	}

	public Product(String sname, String owner, String price) {
		super();
		this.sname = sname;
		this.owner = owner;
		this.price = price;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [sname=" + sname + ", owner=" + owner + ", price=" + price + ", getSname()=" + getSname()
				+ ", getOwner()=" + getOwner() + ", getPrice()=" + getPrice() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

			
			
	
}
