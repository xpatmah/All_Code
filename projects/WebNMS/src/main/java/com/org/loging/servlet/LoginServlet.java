package com.org.loging.servlet;

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

import com.java.webnms.response.NE;
import com.org.bits.webNMS.domain.interfaces.NeDashBoard;
import com.org.bits.webNMS.domain.maps.ALLInfo;
import com.org.database.manager.DataBaseManager;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispather;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do GET Method is called from Xml Servlet");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		String password = getEncryptedString(request.getParameter("pwd"));
		
	    boolean isValidUser = LogingTasks.validateUser(userName, password);
	    if(isValidUser){
	    	request.setAttribute("isValidUser", true);
	    	HttpSession session = request.getSession();
	    	session.setAttribute("userName", userName);
	    	session.setAttribute("pwd", request.getParameter("pwd"));
	    	ALLInfo.neList.clear();
	    	NeDashBoard useNetwork = DataBaseManager.getInstance().getNeDashBard(userName);
	    	String ip="";
	    	
	    		Map<String, String> enrolledNe = useNetwork.getNeportinfo();
	    		
	    		for(Map.Entry<String, String> entry : enrolledNe.entrySet()){
	    			if(null==ALLInfo.ipSocketMap.get(entry.getKey())){
	    				ip = entry.getKey();
	    				try{
	    					Socket socket = new Socket("localhost",Integer.parseInt(entry.getValue()));
		    				ALLInfo.ipSocketMap.put(entry.getKey(), socket);
	    				}catch (IOException e) {
	    		    		System.out.println("Socket is not available for "+ip);
	    		    		DataBaseManager.getInstance().clearDatabaseEntry(ip);
	    		    	}
	    				
	    			}
	    		}
	    	try {
	    		Set<String> entry = enrolledNe.keySet();
	    		for(String eleip : entry){
	    			Socket socket = ALLInfo.ipSocketMap.get(eleip);
	    			if(null!=socket && socket.isConnected()){
	    				PrintWriter printWriter=null;
	    				ObjectInputStream inputStr=null;
	    				if(ALLInfo.outPutStreamMap.get(eleip)==null){
	    					printWriter = new PrintWriter(socket.getOutputStream(), true);
	    					ALLInfo.outPutStreamMap.put(eleip,printWriter);
	    				}else{
	    					printWriter = ALLInfo.outPutStreamMap.get(eleip);
	    				}
	    				if(ALLInfo.inputStreamMap.get(eleip)==null){
	    					inputStr = new ObjectInputStream(socket.getInputStream());
	    					ALLInfo.inputStreamMap.put(eleip,inputStr);
	    				}else{
	    					inputStr = ALLInfo.inputStreamMap.get(eleip);
	    				}
	    				printWriter.println("(((ACT-LOGIN:"+eleip+":"+enrolledNe.get(eleip)+":)))");
	    				try {
	    					NE ne = (NE)inputStr.readObject();
	    					ALLInfo.neList.add(ne);
	    				}catch (ClassNotFoundException e) {
	    					e.printStackTrace();
	    				}
	    			}
	    		} 
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    	request.setAttribute("userDashBoard", useNetwork);
	    	request.setAttribute("neList", ALLInfo.neList);
	    	dispather= request.getRequestDispatcher("enrolledNE.jsp");
	    	dispather.forward(request, response);		
	    }else{
            request.setAttribute("isValidUser", false);
			dispather=request.getRequestDispatcher("login.jsp");
			dispather.forward(request, response);
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
