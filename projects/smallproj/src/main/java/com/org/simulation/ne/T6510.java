package com.org.simulation.ne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.java.webnms.response.Alarm;
import com.java.webnms.response.Card;
import com.java.webnms.response.Facility;
import com.java.webnms.response.NE;
import com.org.simulation.ne.database.DataBaseManager;

public class T6510 implements Runnable{

	private String ip; 
	private String port;
	private ServerSocket listner;
	private Socket socket;
	private ObjectOutputStream out ;
	private AtomicBoolean isdone = new AtomicBoolean(true);
	
	public String getIp() {
		return ip;
	}

	public String getPort() {
		return port;
	}

	public ServerSocket getListner() {
		return listner;
	}

	public Socket getSocket() {
		return socket;
	}
	
	public AtomicBoolean getIsdone() {
		return isdone;
	}

	public T6510(String ip , String port) {
		this.ip=ip;
		this.port=port;
	}
	
	@Override
	public void run() {
		startNe();
	}
	
	private void startNe(){
		while(isdone.get()){
		try {
			listner = new ServerSocket(Integer.parseInt(port));
			listner.setReuseAddress(true);
			BufferedReader reader =null;
			socket = listner.accept();
			socket.setReuseAddress(true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out =new ObjectOutputStream(socket.getOutputStream());
			String msgFormClient = null;
			while(null!=(msgFormClient =reader.readLine())){
				System.out.println(msgFormClient);
				processMessage(msgFormClient);
			}
		}catch (IOException e) {
			try {
				listner.close();
			} catch (IOException e1) {
			}
			System.out.println("Socket is Closed :"+port);
		}
		}
	}
	
	
	private void processMessage(String msgFormClient){
		if(null!=msgFormClient && msgFormClient.contains(Command.ACTLOGIN.getComm())){
			String[] ipPortAddress = msgFormClient.split(":");
			NE ne = DataBaseManager.getInstance().getNEinfo(ipPortAddress[1],ipPortAddress[2]);
			try {
				out.writeObject(ne);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.NEINFO.getComm())){
			String[] ipPortAddress = msgFormClient.split(":");
			NE ne = DataBaseManager.getInstance().getNEinfo(ipPortAddress[1],ipPortAddress[2]);
			try {
				out.writeObject(ne);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.RTRVEQPTALL.getComm())){
			String[] ipPortAddress = msgFormClient.split(":");
			List<Card> cardList = DataBaseManager.getInstance().getAllCardsResponse(ipPortAddress[1]);
			try {
				for(Card card: cardList){
				out.writeObject(card);
				}
				out.writeObject(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.RTRVPORTFAC.getComm())){
			String[] ipPortAddress = msgFormClient.split(":");
			List<Facility> facList = DataBaseManager.getInstance().getResponseFacilityOnSlot(ipPortAddress[1],ipPortAddress[0].split("-")[3]);
			try {
				for(Facility fac: facList){
					out.writeObject(fac);
				}
				out.writeObject(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.RTRVALARMALL.getComm())){
			String[] ipPortAddress = msgFormClient.split(":");
			List<Alarm> alarmList = DataBaseManager.getInstance().getAllNEAlarmsResponse(ipPortAddress[1]);
			try {
				for(Alarm alarm: alarmList){
					out.writeObject(alarm);
				}
				out.writeObject(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.RTRVSLOTSALL.getComm())){
			String[] ipPortAddress = msgFormClient.split(":");
			List<String> emptySlot = DataBaseManager.getInstance().getEmptySlots(ipPortAddress[1]);
			try {
				for(String alarm: emptySlot){
					out.writeObject(alarm);
				}
				out.writeObject(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.RTRVPORTSALL.getComm())){
			String[] ipPortAddress = msgFormClient.split(":");
			List<String> emptyPorts = DataBaseManager.getInstance().getEmptyPorts(ipPortAddress[1], ipPortAddress[0].split("-")[3]);
			try {
				for(String alarm: emptyPorts){
					out.writeObject(alarm);
				}
				out.writeObject(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.RTRVFACILITY.getComm())){
			String[] ipPortAddress = msgFormClient.split(":");
			List<String> emptyPorts = DataBaseManager.getInstance().getEmptyPorts(ipPortAddress[1], ipPortAddress[0].split("-")[3]);
			try {
				for(String fac: emptyPorts){
					out.writeObject(fac);
				}
				out.writeObject(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.RTRVFACILITYALL.getComm())){
			String[] ipPortAddress = msgFormClient.split(":");
			List<com.org.simulation.ne.domain.Facility> emptyPorts = DataBaseManager.getInstance().getAllFacilityOnSlot(ipPortAddress[1], ipPortAddress[0].split("-")[3]);
			List<Facility> facList = new ArrayList<Facility>();
			converttoResponse(facList, emptyPorts);
			try {
				for(Facility fac: facList){
					out.writeObject(fac);
				}
				out.writeObject(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.ENTCARD.getComm())){
			msgFormClient = msgFormClient.replace("(((", "");
			msgFormClient = msgFormClient.replace(")))", "");
			msgFormClient = msgFormClient.replace(";", "");
			String[] ipPortAddress = msgFormClient.split(":");
			String cardname = ipPortAddress[0].split("-")[2];
			com.org.simulation.ne.domain.Card card = new com.org.simulation.ne.domain.Card();
			card.setCardName(cardname);
			card.setSerialNo("SFWB"+System.currentTimeMillis());
			for(int i=1;i<ipPortAddress.length;i++){
				String attribute = ipPortAddress[i].split("=")[0];
				if(attribute.equals("IP")){
					card.setIp(ipPortAddress[i].split("=")[1].trim());
				}else if(attribute.equals("SLOT")){
					card.setSlot(ipPortAddress[i].split("=")[1]);
					card.setId(card.getCardName().trim()+"-"+card.getSlot().trim());
				}else if(attribute.equals("PEC")){
					card.setProvisionPec(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("PS")){
					card.setPrimaryState(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("MODE")){
					card.setMod(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("PROFILE")){
					card.setProfile(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("TRAFIC")){
					card.setTraficStatus(ipPortAddress[i].split("=")[1]);
				}
			}
			String result = DataBaseManager.getInstance().insertCardHtml(card, card.getIp());
			try {
				out.writeObject(result);
				out.writeObject(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.EDCARD.getComm())){
			msgFormClient = msgFormClient.replace("(((", "");
			msgFormClient = msgFormClient.replace(")))", "");
			msgFormClient = msgFormClient.replace(";", "");
			String[] ipPortAddress = msgFormClient.split(":");
			String cardname = ipPortAddress[0].split("-")[2];
			com.org.simulation.ne.domain.Card card = new com.org.simulation.ne.domain.Card();
			card.setCardName(cardname);
			for(int i=1;i<ipPortAddress.length;i++){
				String attribute = ipPortAddress[i].split("=")[0];
				if(attribute.equals("IP")){
					card.setIp(ipPortAddress[i].split("=")[1].trim());
				}else if(attribute.equals("SLOT")){
					card.setSlot(ipPortAddress[i].split("=")[1]);
					card.setId(card.getCardName().trim()+"-"+card.getSlot().trim());
				}else if(attribute.equals("PEC")){
					card.setProvisionPec(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("PS")){
					card.setPrimaryState(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("MODE")){
					card.setMod(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("PROFILE")){
					card.setProfile(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("TRAFIC")){
					card.setTraficStatus(ipPortAddress[i].split("=")[1]);
				}
			}
			com.org.simulation.ne.domain.Card cardonSlot = DataBaseManager.getInstance().getCardOnSlot(card.getIp().trim(), card.getSlot());
		    card.setSerialNo(cardonSlot.getSerialNo());
		    DataBaseManager.getInstance().deleteCard(cardonSlot.getId() , cardonSlot.getIp());
		    String result  =DataBaseManager.getInstance().insertCardHtml(card, card.getIp());
			try {
				out.writeObject(result);
				out.writeObject(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.ENTFACILITY.getComm())){
			msgFormClient = msgFormClient.replace("(((", "");
			msgFormClient = msgFormClient.replace(")))", "");
			msgFormClient = msgFormClient.replace(";", "");
			String[] ipPortAddress = msgFormClient.split(":");
			String facilityName = ipPortAddress[0].split("-")[2];
			com.org.simulation.ne.domain.Facility fac = new com.org.simulation.ne.domain.Facility();
			fac.setFacility(facilityName);
			String ip ="";
			String slot="";
			for(int i=1;i<ipPortAddress.length;i++){
				String attribute = ipPortAddress[i].split("=")[0];
				if(attribute.equals("IP")){
					ip = ipPortAddress[i].split("=")[1].trim();
				}else if(attribute.equals("SLOT")){
					slot = ipPortAddress[i].split("=")[1].trim();
				}else if(attribute.equals("PORT")){
					fac.setId(facilityName+"-"+slot+"-"+ipPortAddress[i].split("=")[1].trim());
				}else if(attribute.equals("SERVICETYPE")){
					fac.setServiceType(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("FREQUENCY")){
					fac.setFrequency(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("WAVELENGTH")){
					fac.setWavelength(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("DIFFRENTIALENCODING")){
					fac.setDiffrentialEncoding(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("CDFI")){
					fac.setCdfi(ipPortAddress[i].split("=")[1]);
				}
			}
			String result = DataBaseManager.getInstance().insertFacilityhtml(fac, ip);
			try {
				out.writeObject(result);
				out.writeObject(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(null!=msgFormClient && msgFormClient.contains(Command.EDFACILITY.getComm())){
			msgFormClient = msgFormClient.replace("(((", "");
			msgFormClient = msgFormClient.replace(")))", "");
			msgFormClient = msgFormClient.replace(";", "");
			String[] ipPortAddress = msgFormClient.split(":");
			String facilityName = ipPortAddress[0].split("-")[2];
			com.org.simulation.ne.domain.Facility fac = new com.org.simulation.ne.domain.Facility();
			fac.setFacility(facilityName);
			String ip ="";
			String slot="";
			String port="";
			for(int i=1;i<ipPortAddress.length;i++){
				String attribute = ipPortAddress[i].split("=")[0];
				if(attribute.equals("IP")){
					ip = ipPortAddress[i].split("=")[1].trim();
				}else if(attribute.equals("SLOT")){
					slot = ipPortAddress[i].split("=")[1].trim();
				}else if(attribute.equals("PORT")){
					port = ipPortAddress[i].split("=")[1].trim();
					fac.setId(facilityName+"-"+slot+"-"+ipPortAddress[i].split("=")[1].trim());
				}else if(attribute.equals("SERVICETYPE")){
					fac.setServiceType(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("FREQUENCY")){
					fac.setFrequency(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("WAVELENGTH")){
					fac.setWavelength(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("DIFFRENTIALENCODING")){
					fac.setDiffrentialEncoding(ipPortAddress[i].split("=")[1]);
				}else if(attribute.equals("CDFI")){
					fac.setCdfi(ipPortAddress[i].split("=")[1]);
				}
			}
			//System.out.println();
			com.org.simulation.ne.domain.Facility facility = DataBaseManager.getInstance().getFacilityOnSlotAndPort(ip, slot, port);
			DataBaseManager.getInstance().deleteFac(facility.getId(), ip);
			String result = DataBaseManager.getInstance().insertFacilityhtml(fac, ip);
			try {
				out.writeObject(result);
				out.writeObject(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.DLTCARD.getComm())){
			msgFormClient = msgFormClient.replace("(((", "");
			msgFormClient = msgFormClient.replace(")))", "");
			msgFormClient = msgFormClient.replace(";", "");
			String[] ipPortAddress = msgFormClient.split(":");
			String ip ="";
			String cardId="";
			for(int i=1;i<ipPortAddress.length;i++){
				String attribute = ipPortAddress[i].split("=")[0];
				if(attribute.equals("IP")){
					ip = ipPortAddress[i].split("=")[1].trim();
				}else if(attribute.equals("CARDID")){
					cardId = ipPortAddress[i].split("=")[1].trim();
				}
			}
			String result = DataBaseManager.getInstance().deleteCardhtml(cardId, ip);
			try {
				out.writeObject(result);
				out.writeObject(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.DLTFACILITY.getComm())){	
			msgFormClient = msgFormClient.replace("(((", "");
			msgFormClient = msgFormClient.replace(")))", "");
			msgFormClient = msgFormClient.replace(";", "");
			String[] ipPortAddress = msgFormClient.split(":");
			String ip ="";
			String facilityId="";
			for(int i=1;i<ipPortAddress.length;i++){
				String attribute = ipPortAddress[i].split("=")[0];
				if(attribute.equals("IP")){
					ip = ipPortAddress[i].split("=")[1].trim();
				}else if(attribute.equals("FACILITYID")){
					facilityId = ipPortAddress[i].split("=")[1].trim();
				}
			}
			String result = DataBaseManager.getInstance().deleteFachtml(facilityId, ip);
			try {
				out.writeObject(result);
				out.writeObject(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(null!=msgFormClient && msgFormClient.contains(Command.PURGEALARM.getComm())){	
			msgFormClient = msgFormClient.replace("(((", "");
			msgFormClient = msgFormClient.replace(")))", "");
			msgFormClient = msgFormClient.replace(";", "");
			String[] ipPortAddress = msgFormClient.split(":");
			String ip ="";
			String date="";
			for(int i=1;i<ipPortAddress.length;i++){
				String attribute = ipPortAddress[i].split("=")[0];
				if(attribute.equals("IP")){
					ip = ipPortAddress[i].split("=")[1].trim();
				}else if(attribute.equals("DATE")){
					date = ipPortAddress[i].split("=")[1].trim().replace("-", "");
				}
			}
			String result = DataBaseManager.getInstance().deleteAlarmhtml(ip, date);
			try {
				out.writeObject(result);
				out.writeObject(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private void converttoResponse(List<Facility> facresponseList , List<com.org.simulation.ne.domain.Facility> facList){
		for(com.org.simulation.ne.domain.Facility fac : facList){
			 Facility facility = new Facility();
			 facility.setCdfi(fac.getCdfi());
			 facility.setDiffrentialEncoding(fac.getDiffrentialEncoding());
			 facility.setFacility(fac.getFacility());
			 facility.setFrequency(fac.getFrequency());
			 facility.setId(fac.getId());
			 facility.setServiceType(fac.getServiceType());
			 facility.setWavelength(fac.getWavelength());
             facresponseList.add(facility); 			
		}
	}

	private String executeQuery(){
		String query = "Select * FROM students";
   
		StringBuffer buffer = new StringBuffer();
		
		Statement st;
		try {
			st = DataBaseManager.getInstance().getConnection().createStatement();
			ResultSet rs=st.executeQuery(query);  
			while(rs.next())  
				buffer.append("<"+" "+rs.getInt(1)+" "+rs.getString(2)+" "); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return buffer.toString();
	}
	
	public void stopNe(){
		try {
			if(null!=out){
				out.writeObject("NE_STOP");
			}
			isdone.set(false);
			Thread.sleep(2000);
			listner.close();
		} catch (IOException | InterruptedException e) {
			try {
				socket.close();
			} catch (IOException e1) {
			   System.out.println("Socket is Closed");
			}
		}
	}
}
