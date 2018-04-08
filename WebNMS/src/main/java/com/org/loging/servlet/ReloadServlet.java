package com.org.loging.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.webnms.response.NE;
import com.org.bits.webNMS.domain.interfaces.NeDashBoard;
import com.org.bits.webNMS.domain.maps.ALLInfo;
import com.org.database.manager.DataBaseManager;

@WebServlet(description="reloadServlet" ,urlPatterns="/reloadServlet")
public class ReloadServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispather;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName=(String)session.getAttribute("userName");
		ALLInfo.neList.clear();
    	NeDashBoard useNetwork = DataBaseManager.getInstance().getNeDashBard(userName);
    	try {
    		Map<String, String> enrolledNe = useNetwork.getNeportinfo();
    		for(Map.Entry<String, String> entry : enrolledNe.entrySet()){
    			if(null==ALLInfo.ipSocketMap.get(entry.getKey())){
    				Socket socket = new Socket("localhost",Integer.parseInt(entry.getValue()));
    				ALLInfo.ipSocketMap.put(entry.getKey(), socket);
    			}
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	try {
    		Map<String, String> enrolledNe = useNetwork.getNeportinfo();
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
    				printWriter.println("(((NE-INFO:"+eleip+":"+enrolledNe.get(eleip)+":)))");
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
     	request.setAttribute("neList", ALLInfo.neList);
    	dispather= request.getRequestDispatcher("enrolledNE.jsp");
    	dispather.forward(request, response);	
	}
}
