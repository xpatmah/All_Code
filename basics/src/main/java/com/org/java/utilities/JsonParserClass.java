package com.org.java.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
	        URL url =    JsonParserClass.class.getResource("./json/ws-system.json");
			System.out.println(url);
			ObjectMapper mapper = new ObjectMapper();
			String key = "id"; //whatever
			FileReader reader1 = new FileReader(url.getPath());
			JsonNode node = mapper.readTree(reader1);
			JSONObject obj = new JSONObject(node.toString());
			/*System.out.println(obj);
			System.out.println(obj.getJSONObject("data"));
			
			JsonNode idNode = node.findValue("id");
			for(JsonNode childNode : idNode){
				 System.out.println(childNode.get("id"));
				 
			}*/
			
			
			System.out.println(obj.toString());
			FileReader reader = new FileReader(url.getPath());
	        BufferedReader bufferReader = new BufferedReader(reader);
	        String responseString="";
	        String line="";
			while((line=bufferReader.readLine())!=null){
				    if(line.contains("\"$SiteID\"")){
				    	line = line.replace("\"$SiteID\"", "1");
				    }else if(line.contains("\"$groupID\"")){
				    	line = line.replace("\"$groupID\"", "1");
				    }else if(line.contains("\"$member-id\"")){
				    	line = line.replace("\"$member-id\"", "1");
				    }
                    responseString +=line+"\n";		
			}
			System.out.println(responseString);
			bufferReader.close();
		} catch (FileNotFoundException | JSONException e) {
			e.printStackTrace();
		}
	}

}
