package com.sample.app.mokito;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.mockserver.client.server.MockServerClient;
import org.mockserver.mockserver.MockServer;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException, JSONException
    {  
       App a1 = new App();
       a1.start();
        
    }
    
    public void start() throws JSONException {  
    	JSONObject onj =  new JSONObject();
    	onj.put("Hey", "dude");
    	onj.put("This", "is mY First POC");
    	
    	MockServer server =  new MockServer(9090);
    	MockServerClient client =  new MockServerClient("localhost", 9090);
    	client.when(request().withMethod("GET")
    	                 .withPath("/policy/rest/file")
    	         )
    	         .respond(
    	             response()
    	                 .withBody(onj.toString())
    	         );

    	//ClientAndServer.startClientAndServer(9090);
    }
    
}
