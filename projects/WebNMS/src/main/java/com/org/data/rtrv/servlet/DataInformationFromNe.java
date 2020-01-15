package com.org.data.rtrv.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.java.webnms.response.Card;
import com.java.webnms.response.Facility;
import com.org.bits.webNMS.domain.interfaces.NeDashBoard;
import com.org.bits.webNMS.domain.maps.ALLInfo;
import com.org.database.manager.DataBaseManager;
import com.org.loging.servlet.LogingTasks;


@WebServlet(description="Data Info From NE" , urlPatterns={"/getdata"})
public class DataInformationFromNe extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8649960077098675110L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ip = (String)req.getSession().getAttribute("Ip");

		System.out.println(ip+ this.getClass().getName()+" is cAlled ");

		String userName = (String)req.getSession().getAttribute("userName");
		
		PrintWriter writer = resp.getWriter();

		String password = ALLInfo.getEncryptedString((String)req.getSession().getAttribute("pwd"));

		boolean isValidUser = LogingTasks.validateUser(userName, password);
		
    	NeDashBoard useNetwork = DataBaseManager.getInstance().getNeDashBard(userName);
    	Map<String, String> enrolledNe = useNetwork.getNeportinfo();
		Socket socket = ALLInfo.ipSocketMap.get(ip);
		if(isValidUser){
			String info = req.getParameter("INFO");	
			if(null!=socket && socket.isConnected()){
				PrintWriter printWriter=ALLInfo.outPutStreamMap.get(ip);
				ObjectInputStream inputStr= ALLInfo.inputStreamMap.get(ip);
				if(null!=printWriter && null!=inputStr){
					if(info.equals("SLOTS")){
						List<String> emptyPortList = new ArrayList<String>();
						printWriter.println("(((RTRV-SLOTS-ALL:"+ip+":"+enrolledNe.get(ip)+":)))");
						try {
							Object obj;
							while(null!=(obj=inputStr.readObject())){
								emptyPortList.add((String)obj);
							}
							JSONObject obje = new JSONObject();
							try {
							if(emptyPortList.size()>0){
								String emptySlotss = Arrays.toString(emptyPortList.toArray());
								emptySlotss = emptySlotss.replace("[", "");
								emptySlotss = emptySlotss.replace("]", "");
								obje.put("EMPTYSLOTS",emptySlotss);
							}else{
								obje.put("EMPTYSLOTS","XXXX");
							}
							writer.write(obje.toString());
					    	writer.flush();
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
		            }else if(info.equals("PORTS")){
		            	String cardid = req.getParameter("CARDID");	
		            	List<String> emptyPortList = new ArrayList<String>();
		            	printWriter.println("(((RTRV-PORTS-ALL-"+cardid.split("-")[1]+":"+ip+":"+enrolledNe.get(ip)+":)))");
		            	Object obj;
						try {
							while(null!=(obj=inputStr.readObject())){
								emptyPortList.add((String)obj);
							}
							JSONObject obje = new JSONObject();
							if(emptyPortList.size()>0){
								String emptyportsss = Arrays.toString(emptyPortList.toArray());
								emptyportsss = emptyportsss.replace("[", "");
								emptyportsss = emptyportsss.replace("]", "");
								obje.put("EMPTYPORTS",emptyportsss);
							}else{
								obje.put("EMPTYPORTS","XXXX");
							}
							writer.write(obje.toString());
					    	writer.flush();
						} catch (ClassNotFoundException | JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }else if(info.equals("FACILITY")){
		            	String cardid = req.getParameter("CARDID");	
		            	List<Facility> facility = new ArrayList<Facility>();
		            	printWriter.println("(((RTRV-FACILITY-ALL-"+cardid.split("-")[1]+":"+ip+":"+enrolledNe.get(ip)+":)))");
		            	Object obj;
						try {
							while(null!=(obj=inputStr.readObject())){
								facility.add((Facility)obj);
							}
							JSONObject[] jsonObj = new JSONObject[facility.size()];
							int i=0;
							for(Facility fac : facility){
								JSONObject facilityObj = new JSONObject();
								facilityObj.put("Id",fac.getId()); 
								facilityObj.put("Cdfi",fac.getCdfi()); 
								facilityObj.put("DiffrentialEncoding",fac.getDiffrentialEncoding()); 
								facilityObj.put("Facility",fac.getFacility()); 
								facilityObj.put("Frequency",fac.getFrequency()); 
								facilityObj.put("ServiceType",fac.getServiceType()); 
								facilityObj.put("WaveLength",fac.getWavelength()); 
								jsonObj[i++] =facilityObj; 
							}
							JSONObject jsonResponse = new JSONObject();
							jsonResponse.put("ALLFAC", jsonObj);
							writer.write(jsonResponse.toString());
					    	writer.flush();
						} catch (ClassNotFoundException | JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }
				}
			}
		}
	}
}
