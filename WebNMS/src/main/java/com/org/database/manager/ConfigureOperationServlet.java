package com.org.database.manager;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
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

import com.java.webnms.response.Card;
import com.java.webnms.response.Facility;
import com.org.bits.webNMS.domain.interfaces.NeDashBoard;
import com.org.bits.webNMS.domain.maps.ALLInfo;
import com.org.loging.servlet.LogingTasks;

@WebServlet(description="Operation servlet", urlPatterns={"/operation"})
public class ConfigureOperationServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1200289139505923134L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ip = (String)req.getSession().getAttribute("Ip");
		System.out.println(ip+ this.getClass().getName()+" is cAlled ");
		PrintWriter writer = resp.getWriter();
		String userName = (String)req.getSession().getAttribute("userName");
		String password = ALLInfo.getEncryptedString((String)req.getSession().getAttribute("pwd"));
		 boolean isValidUser = LogingTasks.validateUser(userName, password);
		    if(isValidUser){
				Socket socket = ALLInfo.ipSocketMap.get(ip);
				if(null!=socket && socket.isConnected()){
					PrintWriter printWriter=ALLInfo.outPutStreamMap.get(ip);
					ObjectInputStream inputStr= ALLInfo.inputStreamMap.get(ip);
					if(null!=printWriter && null!=inputStr){
						String operation = (String)req.getParameter("OPERATION");
						if(operation.equals("ENT-CARD")){
							String slot = (String)req.getParameter("SLOT").trim();
							String card = (String)req.getParameter("CARD").trim();
							String pec = (String)req.getParameter("PEC").trim();
							String primaryState = (String)req.getParameter("PRIMARYSTATE").trim();
							String mode = (String)req.getParameter("MODE").trim();
							String profile = (String)req.getParameter("PROFILE").trim();
							String trafic = (String)req.getParameter("TRAFIC").trim();
                            String Command = "(((ENT-CARD-"+card+":IP="+ip+":SLOT="+slot+":PEC="+pec+":PS="+primaryState+":MODE="+mode+":PROFILE="+profile+":TRAFIC="+trafic+";)))";
							System.out.println(Command);
							printWriter.println(Command);
							try {
								Object obj;
								while(null!=(obj=inputStr.readObject())){
							        String result = (String)obj;
							        String[] resultObj = result.split("::");
                                    JSONObject jsonObj = new JSONObject();									
									jsonObj.put("RESULT", resultObj[0]);
									jsonObj.put("ID", resultObj[1]);
									jsonObj.put("SN", resultObj[2]);
									writer.write(jsonObj.toString());
							    	writer.flush();
								}
							}catch (ClassNotFoundException | JSONException e) {
								e.printStackTrace();
							}
						}else if(operation.equals("ENT-FACILITY")){
							String port = (String)req.getParameter("PORT").trim();
							String faclity = (String)req.getParameter("FACILITY").trim();
							String serviceType = (String)req.getParameter("SERVICETYPE").trim();
							String frequency = (String)req.getParameter("FREQUENCY").trim();
							String wavelength = (String)req.getParameter("WAVELENGTH").trim();
							String diffrentialEncoding = (String)req.getParameter("DIFFRENTIALENCODING").trim();
							String cdfi = (String)req.getParameter("CDFI").trim();
							if("".equals(cdfi)){
								cdfi = " ";
							}
							String slot = (String)req.getParameter("SLOT");
                            String Command = "(((ENT-FACILITY-"+faclity+":IP="+ip+":SLOT="+slot+":PORT="+port+":SERVICETYPE="+serviceType+":FREQUENCY="+frequency+":WAVELENGTH="+wavelength+":DIFFRENTIALENCODING="+diffrentialEncoding+":CDFI="+cdfi+";)))";
							System.out.println(Command);
							printWriter.println(Command);
							try {
								Object obj;
								while(null!=(obj=inputStr.readObject())){
							        String result = (String)obj;
							        String[] resultObj = result.split("::");
                                    JSONObject jsonObj = new JSONObject();									
									jsonObj.put("RESULT", resultObj[0]);
									jsonObj.put("ID", resultObj[1]);
									writer.write(jsonObj.toString());
							    	writer.flush();
								}
							}catch (ClassNotFoundException | JSONException e) {
								e.printStackTrace();
							}
						}else if(operation.equals("ED-CARD")){
							String slot = (String)req.getParameter("SLOT").trim();
							String card = (String)req.getParameter("CARD").trim();
							String pec = (String)req.getParameter("PEC").trim();
							String primaryState = (String)req.getParameter("PRIMARYSTATE").trim();
							String mode = (String)req.getParameter("MODE").trim();
							String profile = (String)req.getParameter("PROFILE").trim();
							String trafic = (String)req.getParameter("TRAFIC").trim();
                            String Command = "(((ED-CARD-"+card+":IP="+ip+":SLOT="+slot+":PEC="+pec+":PS="+primaryState+":MODE="+mode+":PROFILE="+profile+":TRAFIC="+trafic+";)))";
							System.out.println(Command);
							printWriter.println(Command);
							try {
								Object obj;
								while(null!=(obj=inputStr.readObject())){
								    String result = (String)obj;
							        String[] resultObj = result.split("::");
                                    JSONObject jsonObj = new JSONObject();									
									jsonObj.put("RESULT", resultObj[0]);
									jsonObj.put("ID", resultObj[1]);
									jsonObj.put("SN", resultObj[2]);
									writer.write(jsonObj.toString());
							    	writer.flush();
								}
							}catch (ClassNotFoundException | JSONException e) {
								e.printStackTrace();
							}
						}else if(operation.equals("ED-FACILITY")){
							String port = (String)req.getParameter("PORT").trim();
							String faclity = (String)req.getParameter("FACILITY").trim();
							String serviceType = (String)req.getParameter("SERVICETYPE").trim();
							String frequency = (String)req.getParameter("FREQUENCY").trim();
							String wavelength = (String)req.getParameter("WAVELENGTH").trim();
							String diffrentialEncoding = (String)req.getParameter("DIFFRENTIALENCODING").trim();
							String cdfi = (String)req.getParameter("CDFI").trim();
							if("".equals(cdfi)){
								cdfi = " ";
							}
							String slot = (String)req.getParameter("SLOT");
                            String Command = "(((ED-FACILITY-"+faclity+":IP="+ip+":SLOT="+slot+":PORT="+port+":SERVICETYPE="+serviceType+":FREQUENCY="+frequency+":WAVELENGTH="+wavelength+":DIFFRENTIALENCODING="+diffrentialEncoding+":CDFI="+cdfi+";)))";
							System.out.println(Command);
							printWriter.println(Command);
							try {
								Object obj;
								while(null!=(obj=inputStr.readObject())){
							        String result = (String)obj;
							        String[] resultObj = result.split("::");
                                    JSONObject jsonObj = new JSONObject();									
									jsonObj.put("RESULT", resultObj[0]);
									jsonObj.put("ID", resultObj[1]);
									writer.write(jsonObj.toString());
							    	writer.flush();
								}
							}catch (ClassNotFoundException | JSONException e) {
								e.printStackTrace();
							}
						}else if(operation.equals("DLT-CARD")){
							String cardId = (String)req.getParameter("CARDID").trim();
							String card = (String)req.getParameter("CARD").trim();
							String Command = "(((DLT-CARD-"+card+":IP="+ip+":CARDID="+cardId+";)))";
							//System.out.println(Command);
							printWriter.println(Command);
							try {
								Object obj;
								while(null!=(obj=inputStr.readObject())){
								    String result = (String)obj;
							        String[] resultObj = result.split("::");
                                    JSONObject jsonObj = new JSONObject();									
									jsonObj.put("RESULT", resultObj[0]);
									writer.write(jsonObj.toString());
							    	writer.flush();
								}
							}catch (ClassNotFoundException | JSONException e) {
								e.printStackTrace();
							}
						}else if(operation.equals("DLT-FACILITY")){
							String facilityId = (String)req.getParameter("FACILITYID").trim();
							String facility = (String)req.getParameter("FACILITY").trim();
							String Command = "(((DLT-FACILITY-"+facility+":IP="+ip+":FACILITYID="+facilityId+";)))";
							//System.out.println(Command);
							printWriter.println(Command);
							try {
								Object obj;
								while(null!=(obj=inputStr.readObject())){
								    String result = (String)obj;
							        String[] resultObj = result.split("::");
                                    JSONObject jsonObj = new JSONObject();									
									jsonObj.put("RESULT", resultObj[0]);
									writer.write(jsonObj.toString());
							    	writer.flush();
								}
							}catch (ClassNotFoundException | JSONException e) {
								e.printStackTrace();
							}
						}else if(operation.equals("PURGE")){
							String date = (String)req.getParameter("DATE").trim();
							String Command = "(((PURGE-ALARM:IP="+ip+":DATE="+date+";)))";
							//System.out.println(Command);
							printWriter.println(Command);
							try {
								Object obj;
								while(null!=(obj=inputStr.readObject())){
								    String result = (String)obj;
							        String[] resultObj = result.split("::");
                                    JSONObject jsonObj = new JSONObject();									
									jsonObj.put("RESULT", resultObj[0]);
									writer.write(jsonObj.toString());
							    	writer.flush();
								}
							}catch (ClassNotFoundException | JSONException e) {
								e.printStackTrace();
							}
						}
						
					}
				}
		    }
	}
}
