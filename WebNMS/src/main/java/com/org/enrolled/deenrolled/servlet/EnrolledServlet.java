package com.org.enrolled.deenrolled.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.java.webnms.response.NE;
import com.org.bits.webNMS.domain.interfaces.NeDashBoard;
import com.org.bits.webNMS.domain.maps.ALLInfo;
import com.org.database.manager.DataBaseManager;
import com.org.loging.servlet.LogingTasks;
import com.sun.java.swing.plaf.windows.resources.windows;

public class EnrolledServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7534038073773373805L;
	
	RequestDispatcher dispather;
	
	boolean requestToAdd;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*****");
		requestToAdd=false;
		boolean alreadyAdded=false;
		response.setContentType("application/json");
		PrintWriter writer = response.getWriter();
		String ip = request.getParameter("ip");
		String port = request.getParameter("port");
		System.out.println(ip+ " "+ port);
		//writer.write(port+" "+port);

		String userName = (String)request.getSession().getAttribute("userName");
		String password = getEncryptedString((String)request.getSession().getAttribute("pwd"));
		
	  	NeDashBoard useNetwork = DataBaseManager.getInstance().getNeDashBard(userName);
		
    		Map<String, String> enrolledNe = useNetwork.getNeportinfo();
    		for(Map.Entry<String, String> entry : enrolledNe.entrySet()){
    			if(entry.getKey().equals(ip)){
    				alreadyAdded=true;
    			}
    		}
	    boolean isValidUser = LogingTasks.validateUser(userName, password);
	    if(alreadyAdded){
	    	JSONObject obj = new JSONObject();
	    	try {
				obj.put("Result","Allready Added in the network");
				writer.write(obj.toString());
		    	writer.flush();
			} catch (JSONException e) {
				e.printStackTrace();
			}
	    }else if(isValidUser){
	    	try {
	    		if(null==ALLInfo.ipSocketMap.get(ip)){
	    			Socket socket = new Socket("localhost",Integer.parseInt(port));
	    			ALLInfo.ipSocketMap.put(ip, socket);
	    		}
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	try {
	    		 Socket socket = ALLInfo.ipSocketMap.get(ip);
	    			if(null!=socket && socket.isConnected()){
	    				PrintWriter printWriter=null;
	    				ObjectInputStream inputStr=null;
	    				if(ALLInfo.outPutStreamMap.get(ip)==null){
	    					printWriter = new PrintWriter(socket.getOutputStream(), true);
	    					ALLInfo.outPutStreamMap.put(ip,printWriter);
	    				}else{
	    					printWriter = ALLInfo.outPutStreamMap.get(ip);
	    				}
	    				if(ALLInfo.inputStreamMap.get(ip)==null){
	    					inputStr = new ObjectInputStream(socket.getInputStream());
	    					ALLInfo.inputStreamMap.put(ip,inputStr);
	    				}else{
	    					inputStr = ALLInfo.inputStreamMap.get(ip);
	    				}
	    				printWriter.println("(((ACT-LOGIN:"+ip+":"+port+":)))");
	    				try {
	    					NE ne = (NE)inputStr.readObject();
	    					ALLInfo.neList.add(ne);
	    					DataBaseManager.getInstance().insertNEintoDatabase(userName,ip,port);
		    				JSONObject obj = new JSONObject();
		    				obj.put("Ip"     , ne.getIp());
		    				obj.put("AreaServed"        , ne.getAreaServed());
		    				obj.put("Location"           , ne.getLocation());
		    				obj.put("Name"            , ne.getName());
		    				obj.put("Port"          , ne.getPort());
		    				obj.put("Shelf"            , ne.getShelf());
		    				obj.put("SoftwareVersion"  , ne.getSoftwareversion());
		    				obj.put("Status"          , ne.getStatus());
		    				obj.put("SyncStatus"      , ne.getSyncstatus());
		    				obj.put("Result","Success");
		    				writer.write(obj.toString());
		    		    	writer.flush();
	    				}catch (ClassNotFoundException | JSONException e) {
	    					e.printStackTrace();
	    				}
	    			}else{
	    				JSONObject obj = new JSONObject();
	    		    	try {
	    					obj.put("Result","NE is not Available");
	    					writer.write(obj.toString());
	    			    	writer.flush();
	    				} catch (JSONException e) {
	    					e.printStackTrace();
	    				}
	    			}
	    	}catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    }else{
	    	JSONObject obj = new JSONObject();
	    	try {
				obj.put("Result","Not a valid user");
				writer.write(obj.toString());
		    	writer.flush();
			} catch (JSONException e) {
				e.printStackTrace();
			}
	    }
	}


	private String getEncryptedString(String password){
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
