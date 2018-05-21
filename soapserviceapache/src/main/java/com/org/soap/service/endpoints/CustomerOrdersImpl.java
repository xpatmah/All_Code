package com.org.soap.service.endpoints;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;

import com.bharath.ws.trainings.CreateOrdersRequest;
import com.bharath.ws.trainings.CreateOrdersResponse;
import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerOrdersImpl implements CustomerOrdersPortType {

	Map<BigInteger, List<Order>> customerOrders = new HashMap<>();
	int currentId;
	
	public CustomerOrdersImpl() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public void init() {
		List<Order> orders = new ArrayList<>();
		Order order = new Order();
		
		order.setId(BigInteger.valueOf(1));
		
		Product product = new Product();
		product.setId("1");
		product.setDescription("IPhone");
		product.setQuantity(BigInteger.valueOf(3));
		order.getProduct().add(product);
		orders.add(order);
		customerOrders.put(BigInteger.valueOf(++currentId), orders);
	}
	
	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger id = request.getCustomerId();
		List<Order> orders = customerOrders.get(id);
		
		GetOrdersResponse response = new GetOrdersResponse();
		response.getOrder().addAll(orders);
		
		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		// TODO Auto-generated method stub
		BigInteger id = request.getCustomerId();
		Order order = request.getOrder();
		
		List<Order> orderList = customerOrders.get(id);
		
		orderList.add(order);	
		
		CreateOrdersResponse response = new CreateOrdersResponse();
		response.setResult(true);
		return response;
	}

}
