package som.org.soapservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService
public class ProductCatalog {

	public List<String> getProductCatalog(){
		List<String> productList = new ArrayList<>();
		productList.add("Video Game");
		productList.add("Cricket Bat");
		productList.add("Hockey");
		
		return productList;
	
	}
	
}
