package com.org.java.databases.practice;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBaseClient {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/serverinfodatabase","root","root");
					
					String query = "INSERT INTO USERINFO (ID , PASSWORD) VALUES ('ADMIN' ,'"+getEncryptedString("ADMIN")+"')";
					String query1 = "INSERT INTO USERINFO (ID , PASSWORD) VALUES ('ADMIN_21074' ,'"+getEncryptedString("ADMIN_21074")+"')";
					String query2 = "INSERT INTO USERINFO (ID , PASSWORD) VALUES ('ADMIN_244713' ,'"+getEncryptedString("ADMIN_244713")+"')";
					String query3 = "INSERT INTO USERINFO (ID , PASSWORD) VALUES ('ADMIN_122001' ,'"+getEncryptedString("ADMIN_122001")+"')";
					String query4 = "INSERT INTO USERINFO (ID , PASSWORD) VALUES ('ADMIN_122002' ,'"+getEncryptedString("ADMIN_122002")+"')";
					
					Statement st = con.createStatement();
					
					st.executeUpdate(query);  
					Thread.sleep(1000);
					st.executeUpdate(query1);  
					Thread.sleep(1000);
					st.executeUpdate(query2);  
					Thread.sleep(1000);
					st.executeUpdate(query3);  
					Thread.sleep(1000);
					st.executeUpdate(query4);  
					
					Thread.sleep(1000);
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
	    try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	private static String getEncryptedString(String password){
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
		    byte[] psssBytes = password.getBytes();
			md.reset();
			byte[] digestedBytes = md.digest(psssBytes);
			
            for(int db=0 ;db<digestedBytes.length;db++){
            sb.append(Integer.toHexString(0xff & digestedBytes[db]));	
            }			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
}
