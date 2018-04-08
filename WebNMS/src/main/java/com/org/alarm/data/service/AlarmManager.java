package com.org.alarm.data.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.webnms.response.Alarm;
import com.java.webnms.response.Card;
import com.org.bits.webNMS.domain.interfaces.NeDashBoard;
import com.org.bits.webNMS.domain.maps.ALLInfo;
import com.org.database.manager.DataBaseManager;
import com.org.loging.servlet.LogingTasks;



@WebServlet(description="Alarm Retreiver", urlPatterns={"/alarms"})
public class AlarmManager extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -251207781278720318L;

    RequestDispatcher dispather;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ip = request.getParameter("Ip");
		if(null!=ip){
			request.getSession().setAttribute("Ip", ip);
		}else{
			 ip = (String)request.getSession().getAttribute("Ip");
		}
		System.out.println(ip+ this.getClass().getName()+" is cAlled ");
	    List<Alarm> alarmList = new ArrayList<Alarm>();
		String userName = (String)request.getSession().getAttribute("userName");
		String password = getEncryptedString((String)request.getSession().getAttribute("pwd"));
		
	    boolean isValidUser = LogingTasks.validateUser(userName, password);
	    if(isValidUser){
	    	NeDashBoard useNetwork = DataBaseManager.getInstance().getNeDashBard(userName);
	    	Map<String, String> enrolledNe = useNetwork.getNeportinfo();
			Socket socket = ALLInfo.ipSocketMap.get(ip);
			if(null!=socket && socket.isConnected()){
				PrintWriter printWriter=ALLInfo.outPutStreamMap.get(ip);
				ObjectInputStream inputStr= ALLInfo.inputStreamMap.get(ip);
				if(null!=printWriter && null!=inputStr){
					printWriter.println("(((RTRV-ALARM-ALL:"+ip+":"+enrolledNe.get(ip)+":)))");
					try {
						Object obj;
						while(null!=(obj=inputStr.readObject())){
							alarmList.add((Alarm)obj);
						}
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		   	request.setAttribute("alarmList",alarmList );
			dispather= request.getRequestDispatcher("alarms.jsp");
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
