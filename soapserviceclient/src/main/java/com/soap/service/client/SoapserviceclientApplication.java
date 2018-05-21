package com.soap.service.client;

import java.math.BigInteger;
import java.net.URL;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.org.soap.service.endpoints.CustomerOrdersImplService;

@SpringBootApplication
public class SoapserviceclientApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SoapserviceclientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		CustomerOrdersImplService service = new CustomerOrdersImplService(new URL("http://localhost:8080/soapservice/customerorderservice?wsdl"));
	    CustomerOrdersPortType type = service.getCustomerOrdersImplPort();
	    
	    BigInteger value = BigInteger.valueOf(1);
	    GetOrdersRequest request  = new GetOrdersRequest();
	    		request.setCustomerId(value);
	    GetOrdersResponse response = type.getOrders(request);
	    List<Order> orders = response.getOrder();
	    for(Order o : orders) {
	    	System.out.println(o.getId());
	    }
	}
}
