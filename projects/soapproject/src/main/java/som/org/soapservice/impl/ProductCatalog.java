package som.org.soapservice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

import som.org.soapservice.domain.Product;

@WebService(name="ProductService")
public class ProductCatalog {

	@WebMethod
	public List<String> getProductCatalog(){
		List<String> productList = new ArrayList<>();
		productList.add("Video Game");
		productList.add("Cricket Bat");
		productList.add("Hockey");
		return productList;
	
	}
	
	@WebMethod
	public List<String> getProductList(String product1 , String product2){
		List<String> productList = new ArrayList<>();
		productList.add(product1);
		productList.add(product2);
		return productList;
	}
	
	
	@WebMethod
	public Product getProduct(String name , String owner , String price){
		return new Product(name, owner, price);
	}
	
}
