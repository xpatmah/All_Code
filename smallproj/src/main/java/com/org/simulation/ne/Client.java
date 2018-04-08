package com.org.simulation.ne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		AtomicInteger integert = new AtomicInteger(0);
		
		Socket socket  = new Socket("localhost",1234);
		
		Scanner scan = new Scanner(System.in);
		
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		
		BufferedReader reader  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
	
		while(true){
			try{
			writer.println("ENT-RTRV");
			String msgFormClient = null;
	    	 msgFormClient =reader.readLine();
	    		System.out.println(msgFormClient);
	    		if(null!=msgFormClient && msgFormClient.equals("NE_STOP")){
	    			socket.close();
					break;
	    		}
	    
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}catch(Exception e){
				socket.close();
			}
			if(integert.incrementAndGet()==10){
				socket.close();
				break;
			}
		}
		
	}

}
