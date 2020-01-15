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


@WebServlet(description="Refresh Card Servlet" , urlPatterns={"/refreshCard"})
public class RefreshCardServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3811523292522144905L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ip = (String)req.getSession().getAttribute("Ip");
		System.out.println(ip+ this.getClass().getName()+" is cAlled ");
		PrintWriter writer = resp.getWriter();
	    List<Card> cardList = new ArrayList<Card>();
		String userName = (String)req.getSession().getAttribute("userName");
		String password = ALLInfo.getEncryptedString((String)req.getSession().getAttribute("pwd"));
		
	    boolean isValidUser = LogingTasks.validateUser(userName, password);
	    if(isValidUser){
	    	NeDashBoard useNetwork = DataBaseManager.getInstance().getNeDashBard(userName);
	    	Map<String, String> enrolledNe = useNetwork.getNeportinfo();
			Socket socket = ALLInfo.ipSocketMap.get(ip);
			if(null!=socket && socket.isConnected()){
				PrintWriter printWriter=ALLInfo.outPutStreamMap.get(ip);
				ObjectInputStream inputStr= ALLInfo.inputStreamMap.get(ip);
				if(null!=printWriter && null!=inputStr){
					printWriter.println("(((RTRV-EQPT-ALL:"+ip+":"+enrolledNe.get(ip)+":)))");
					try {
						Object obj;
						while(null!=(obj=inputStr.readObject())){
							cardList.add((Card)obj);
						}
						JSONObject[] jsonObj = new JSONObject[cardList.size()];
						int i=0;
						for(Card card : cardList){
							JSONObject cardObj = new JSONObject();
					     	cardObj.put("Id",card.getId()); 
							cardObj.put("Name",card.getCardName()); 
							cardObj.put("PrimaryState",card.getPrimaryState()); 
							cardObj.put("ProvisionPec",card.getProvisionPec()); 
							cardObj.put("Mode",card.getMod()); 
							cardObj.put("Profile",card.getProfile()); 
							cardObj.put("TraficStatus",card.getTraficStatus()); 
							cardObj.put("SerialNo",card.getSerialNo()); 
							jsonObj[i++] =cardObj; 
						}
						JSONObject jsonResponse = new JSONObject();
						jsonResponse.put("ALLCARD", jsonObj);
						writer.write(jsonResponse.toString());
				    	writer.flush();
					}catch (ClassNotFoundException | JSONException e) {
						e.printStackTrace();
					}
					}
				}
			}
	}
}
