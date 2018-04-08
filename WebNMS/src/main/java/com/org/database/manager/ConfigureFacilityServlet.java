package com.org.database.manager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.java.webnms.response.Facility;
import com.org.bits.webNMS.domain.interfaces.NeDashBoard;
import com.org.bits.webNMS.domain.maps.ALLInfo;
import com.org.loging.servlet.LogingTasks;


@WebServlet(description="Facility Servlet", urlPatterns={"/facilityServlet"})
public class ConfigureFacilityServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5797088825975987466L;

	public ConfigureFacilityServlet() {
	}
	
	@Override	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ip = (String)request.getSession().getAttribute("Ip");
		String cardId = (String)request.getParameter("CARDID");
		System.out.println(ip+ this.getClass().getName()+" is cAlled ");
		PrintWriter writer = response.getWriter();
	    List<Facility> facList = new ArrayList<Facility>();
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
					printWriter.println("(((RTRV-PORT-FAC-"+(cardId).split("-")[1]+":"+ip+":"+enrolledNe.get(ip)+":)))");
					try {
						Object obj;
						while(null!=(obj=inputStr.readObject())){
							facList.add((Facility)obj);
							System.out.println("Object Received");
						}
						JSONObject[] jsonObj = new JSONObject[facList.size()];
						try {
							int i=0;
							for(Facility fac : facList){
								JSONObject facObj = new JSONObject();
								facObj.put("Id",fac.getId()); 
								facObj.put("Cdfi",fac.getCdfi()); 
								facObj.put("DiffrentialEncoding",fac.getDiffrentialEncoding()); 
								facObj.put("Facility",fac.getFacility()); 
								facObj.put("Frequency",fac.getFrequency()); 
								facObj.put("ServiceType",fac.getServiceType()); 
								facObj.put("WaveLength",fac.getWavelength()); 
								jsonObj[i++] =facObj; 
							}
							JSONObject jsonResponse = new JSONObject();
							jsonResponse.put("ALLFAC", jsonObj);
							writer.write(jsonResponse.toString());
					    	writer.flush();
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
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
