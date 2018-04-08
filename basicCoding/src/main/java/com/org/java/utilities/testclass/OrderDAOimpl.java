package com.org.java.utilities.testclass;

import java.util.HashMap;
import java.util.Map;



public class OrderDAOimpl implements OrderDAo ,Cloneable{

	Map<Integer ,Order> orders = new HashMap<>();
	
	
    

	@Override
	public boolean create(Order order) {
		// TODO Auto-generated method stub
        if(orders.containsKey(order.getId())){
        	return false;
        }else{
        	orders.put(order.getId(), order);
        	return true;
        }
	}
  
	
	
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
        if(orders.containsKey( id)){
        	return false;
        }else{
        	orders.remove(id);
        	return true;
        }
	}

	@Override
	public boolean updated(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
