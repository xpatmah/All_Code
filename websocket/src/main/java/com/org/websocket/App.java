package com.org.websocket;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

/**
 * Hello world!
 *
 */
public class App extends Endpoint
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

	@Override
	public void onOpen(Session session, EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}
}
