package com.org.database.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.org.bits.webNMS.domain.interfaces.NeDashBoard;

import sun.security.util.Password;

public class DataBaseManager {
	
	private static DataBaseManager dataBaseManager;
	
	private Connection connection;
	private Statement st;
	
	HashMap<String, String> map= new HashMap<String, String>();
	 private DataBaseManager() {
   		createConnection();	 
	}

	 private void createConnection(){
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 connection=	DriverManager.getConnection("jdbc:mysql://localhost:3306/serverinfodatabase","root","root");
		     st = connection.createStatement();
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				//Need to put central login
				e.printStackTrace();
			}
			
		 
	 }
	 
    public static DataBaseManager getInstance(){
    	if(dataBaseManager==null){
    		synchronized (DataBaseManager.class){
    			if(dataBaseManager==null){
    				dataBaseManager = new DataBaseManager();
    			}
			}
    	}
    	return dataBaseManager;
    }   
    
    public HashMap<String, String> getMap() {
    	return map;
	}
    
    public HashMap<String,String> retreiveAllUsers(){
    	HashMap<String, String> userMap = new HashMap<String, String>();
    	
    	String query = "SELECT * FROM USERINFO";
    	try {
    		if(null!=st){
			ResultSet resultSet = st.executeQuery(query);
    		  while(resultSet.next()){
    			  userMap.put(resultSet.getString(1), resultSet.getString(2));
    		  }
    		}
    		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return userMap;
    	
    }
    
    public NeDashBoard getNeDashBard(String user){
    	NeDashBoard userDashBoard = new NeDashBoard();
    	
    	String query = "select * from serverinfodatabase.enrollednetwork where user=\""+user+"\";";
    	try {
    		if(null!=st){
			ResultSet resultSet = st.executeQuery(query);
    		  while(resultSet.next()){
    			  userDashBoard.setUser(user);
    			  userDashBoard.getNeportinfo().put(resultSet.getString(2), resultSet.getString(3));
    		  }
    		}
    		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return userDashBoard;	
    }
	  
    
    public void insertNEintoDatabase(String user,String ip,String port){
    	String query ="insert into serverinfodatabase.enrollednetwork values (\""+user+"\",\""+ip+"\",\""+port+"\")";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }

	public void deEnrollElement(String ip) {
    	String query ="delete from serverinfodatabase.enrollednetwork where ip=\""+ip+"\"";
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    
	}
	
	public void clearDatabaseEntry(String ip){
		deEnrollElement(ip);
	}
	
	public String getPortForIp(String ip){
		String query = "select Port from serverinfodatabase.enrollednetwork where IP=\""+ip+"\";";
		String port="0000";
		try {
			if(null!=st){
				ResultSet resultSet = st.executeQuery(query);
				while(resultSet.next()){
					port = resultSet.getString(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   	return port;
	}
	
}
