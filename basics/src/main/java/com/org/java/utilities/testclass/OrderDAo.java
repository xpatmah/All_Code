package com.org.java.utilities.testclass;

public interface OrderDAo {

	public boolean create(Order order);
	
	public boolean delete(int id);
	
	public boolean updated(int id);
	
}
