package com.org.websocket;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * Hello world!
 *
 */
@ServerEndpoint("/hello")
public class AppAnnotation
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

	@OnMessage
	public void onOpen(String message , Session session) {
		// TODO Auto-generated method stub
		System.out.println("My Message is "+message);
	}
}
