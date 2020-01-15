package com.org.simulation.ne.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.webnms.response.Alarm;
import com.java.webnms.response.NE;
import com.org.simulation.ne.domain.Card;
import com.org.simulation.ne.domain.Facility;
import com.org.simulation.ne.domain.NeInfo;

public class DataBaseManager {

	private static DataBaseManager databasemanager;
	
	private Connection con=null;
	private DataBaseManager(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nedatabase","root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DataBaseManager getInstance(){
		if(null==databasemanager){
			synchronized (DataBaseManager.class) {
				if(null==databasemanager){
					databasemanager = new DataBaseManager();
				}
			}
		}
		return databasemanager;
	}
	
	
	public Connection getConnection(){
		return con;
	}
	
	public String getShelfType(String ip ,String port){
		String query = "select shelf from nedatabase.neinfo where ip=\""+ip+"\""+" or port=\""+port+"\"";
		String shelfType=null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				shelfType=rs.getString(1);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shelfType;
	}

	public Card getCardOnSlot(String ip , String slot){
		String cardName = "";
		Card card = null;
		String query = "select * from nedatabase.cardinfo where ip=\""+ip+"\"";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				String cardString = rs.getString(2);
				String[] cardSlot = cardString.split("-");
				if(cardSlot[1].equals(slot)){
					card = new Card();
					cardName=cardSlot[0];
					card.setCardName(cardName);
					card.setIp(rs.getString(1));
					card.setId(cardString);
					card.setMod(rs.getString(6));
					card.setPrimaryState(rs.getString(4));
					card.setProfile(rs.getString(7));
					card.setProvisionPec(rs.getString(5));
					card.setSerialNo(rs.getString(9));
					card.setSlot(slot);
					card.setTraficStatus(rs.getString(8));
					break;
				}else{
					cardName="";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return card;
	}
	
	public Facility getFacilityOnSlotAndPort(String ip ,String slot,String port){
		Facility facName = null;
		Facility fac = new Facility();
		String query = "select * from nedatabase.facility where ip=\""+ip+"\"";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				String facility = rs.getString(1);
				String[] facOnPort = facility.split("-");
				if(facOnPort[1].equals(slot) && facOnPort[2].equals(port)){
					fac.setFacility(facOnPort[0]);
					facName=getFacilityValue(rs, fac);
					break;
				}else{
					facName=null;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return facName;
	}
	
	public List<Facility> getAllFacilityOnSlot(String ip ,String slot){
		List<Facility> facList = new ArrayList<Facility>();
	
		String query = "select * from nedatabase.facility where ip=\""+ip+"\"";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				String facility = rs.getString(1);
				String[] facOnPort = facility.split("-");
				Facility fac = new Facility();
				if(facOnPort[1].equals(slot)){
					fac.setFacility(facOnPort[0]);
					Facility facName=getFacilityValue(rs, fac);
					facList.add(facName);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facList;
	}
	

	public NE getNEinfo(String ip , String port) {
		NE response=new NE();
		
		String query = "select * from nedatabase.neinfo where ip=\""+ip+"\""+" and port=\""+port+"\"";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
			 response= new NE();
			 response.setIp(rs.getString(1));
			 response.setPort(rs.getString(2));
			 response.setAreaServed(rs.getString(7));
			 response.setLocation(rs.getString(4));
			 response.setShelf(rs.getString(3));
			 response.setSyncstatus(rs.getString(5));
			 response.setSoftwareversion(rs.getString(6));
			 response.setStatus(rs.getString(8));
			 response.setName(rs.getString(9));                
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	private Facility getFacilityValue(ResultSet rs , Facility fac){
		try {
			fac.setId(rs.getString(1));
			fac.setCdfi(rs.getString(7));
			fac.setDiffrentialEncoding(rs.getString(6));
			fac.setFrequency(rs.getString(4));
			fac.setServiceType(rs.getString(2));
			fac.setWavelength(rs.getString(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fac;
	}
	
	private com.java.webnms.response.Facility getAllResponseFacilityValue(ResultSet rs , com.java.webnms.response.Facility fac){
		try {
			fac.setId(rs.getString(1));
			fac.setCdfi(rs.getString(7));
			fac.setDiffrentialEncoding(rs.getString(6));
			fac.setFrequency(rs.getString(4));
			fac.setServiceType(rs.getString(2));
			fac.setWavelength(rs.getString(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fac;
	}
	
	public List<Card> getAllCards(String ip){
		List<Card> cardList = new ArrayList<Card>();
		String query = "select * from nedatabase.cardinfo where ip=\""+ip+"\"";
		  try {
				Statement st  = con.createStatement();
				ResultSet rst =  st.executeQuery(query);
				while(rst.next()){
					 Card card = new Card();
					 card.setIp(ip);
					 card.setCardName(rst.getString(2).split("-")[0]);
					 card.setId(rst.getString(2));
					 card.setSlot(rst.getString(2).split("-")[1]);
					 card.setMod(rst.getString(6));
					 card.setPrimaryState(rst.getString(4));
					 card.setProfile(rst.getString(7));
					 card.setProvisionPec(rst.getString(5));
					 card.setSerialNo(rst.getString(9));
					 card.setSlot(rst.getString(2).split("-")[1]);
					 card.setTraficStatus(rst.getString(8));
					 cardList.add(card);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return cardList;
		
	}
	
	public List<com.java.webnms.response.Card> getAllCardsResponse(String ip){
		List<com.java.webnms.response.Card> cardList = new ArrayList<com.java.webnms.response.Card>();
		String query = "select * from nedatabase.cardinfo where ip=\""+ip+"\"";
		  try {
				Statement st  = con.createStatement();
				ResultSet rst =  st.executeQuery(query);
				while(rst.next()){
					 com.java.webnms.response.Card card = new com.java.webnms.response.Card();
					 card.setIp(ip);
					 card.setCardName(rst.getString(2).split("-")[0]);
					 card.setId(rst.getString(2));
					 card.setSlot(rst.getString(2).split("-")[1]);
					 card.setMod(rst.getString(6));
					 card.setPrimaryState(rst.getString(4));
					 card.setProfile(rst.getString(7));
					 card.setProvisionPec(rst.getString(5));
					 card.setSerialNo(rst.getString(9));
					 card.setSlot(rst.getString(2).split("-")[1]);
					 card.setTraficStatus(rst.getString(8));
					 cardList.add(card);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return cardList;
	}
	
	
	public List<String> getEmptySlots(String ip){
		String query = "select CARDID from nedatabase.cardinfo where ip=\""+ip+"\"";
		List<String> slotList = new ArrayList<String>();
		slotList.addAll(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12"));
		try {
			Statement st  = con.createStatement();
			ResultSet rst =  st.executeQuery(query);
			while(rst.next()){
				String slot = rst.getString(1);
				String[] split = slot.split("-");
				slotList.remove(split[1]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return slotList;
	}
	
	
	public List<String> getEmptyPorts(String ip , String slot){
		String query = "select FACILITYID from nedatabase.facility where ip=\""+ip+"\"";
		List<String> portList = new ArrayList<String>();
		portList.addAll(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12"));
		try {
			Statement st  = con.createStatement();
			ResultSet rst =  st.executeQuery(query);
			while(rst.next()){
				String facilityId = rst.getString(1);
				String[] split = facilityId.split("-");
				if(split[1].equals(slot)){
					portList.remove(split[2]);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
      return portList;
	}

	
	public List<com.java.webnms.response.Alarm> getAllNEAlarmsResponse(String ip){
		List<com.java.webnms.response.Alarm> alarmList = new ArrayList<com.java.webnms.response.Alarm>();
		String query = "select * from nedatabase.alarms where ip=\""+ip+"\"";
		  try {
				Statement st  = con.createStatement();
				ResultSet rst =  st.executeQuery(query);
				while(rst.next()){
					com.java.webnms.response.Alarm alarm = new com.java.webnms.response.Alarm();
					alarm.setIp(ip);
					alarm.setAlarmid(rst.getString(2)+"");
					alarm.setDiscription(rst.getString(7));
					alarm.setDocumentid(rst.getString(9));
					alarm.setLocation(rst.getString(8));
					alarm.setNename(rst.getString(3));
					alarm.setSeviourity(rst.getString(5));
					alarm.setTime(rst.getString(6));
					alarm.setUnit(rst.getString(4));
					alarmList.add(alarm);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return alarmList;
		
	}
	
	public List<com.java.webnms.response.Facility> getResponseFacilityOnSlot(String ip ,String slot){
		List<com.java.webnms.response.Facility> facList = new ArrayList<com.java.webnms.response.Facility>();
	
		String query = "select * from nedatabase.facility where ip=\""+ip+"\"";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				String facility = rs.getString(1);
				String[] facOnPort = facility.split("-");
				com.java.webnms.response.Facility fac = new com.java.webnms.response.Facility();
				if(facOnPort[1].equals(slot)){
					fac.setFacility(facOnPort[0]);
					com.java.webnms.response.Facility facName=getAllResponseFacilityValue(rs, fac);
					facList.add(facName);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return facList;
	}
	
	public void insertShelfRecord(String ip,String shelf){
		String query ="insert into nedatabase.ipshelf values (\""+ip+"\",\""+shelf+"\")";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertFacility(Facility fac , String ip){
		String query ="insert into nedatabase.facility values (\""+fac.getId()+"\",\""+fac.getServiceType()+"\",\""+ip+"\",\""+fac.getFrequency()+"\",\""+fac.getWavelength()+"\",\""+fac.getDiffrentialEncoding()+"\",\""+fac.getCdfi()+"\")";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String insertFacilityhtml(Facility fac , String ip){
		String query ="insert into nedatabase.facility values (\""+fac.getId()+"\",\""+fac.getServiceType()+"\",\""+ip+"\",\""+fac.getFrequency()+"\",\""+fac.getWavelength()+"\",\""+fac.getDiffrentialEncoding()+"\",\""+fac.getCdfi()+"\")";
		String result;
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
			result = "PASS::"+fac.getId();
		} catch (SQLException e) {
			result = "FAIL::"+fac.getId();
			e.printStackTrace();
		}
		return result;
	}
	
	

	public void deleteFac(String facid , String ip){
		String query ="delete from nedatabase.facility where facilityid=\""+facid+"\" AND IP=\""+ip+"\";";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String deleteFachtml(String facid , String ip){
		String query ="delete from nedatabase.facility where facilityid=\""+facid+"\" AND IP=\""+ip+"\";";
		String result="";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
			result = "PASS";
		} catch (SQLException e) {
			result = "FAIL";
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String deleteAlarmhtml(String ip , String date){
		String query ="delete from nedatabase.alarms where alarmDate < "+date+" AND IP=\""+ip+"\";";
		String result="";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
			result = "PASS";
		} catch (SQLException e) {
			result = "FAIL";
			e.printStackTrace();
		}
		return result;
	}
	
	public void deleteCard(String cardID ,String ip){
		String query ="delete from nedatabase.cardinfo where CARDID=\""+cardID+"\" AND IP=\""+ip+"\";";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String deleteCardhtml(String cardID ,String ip){
		String query ="delete from nedatabase.cardinfo where CARDID=\""+cardID+"\" AND IP=\""+ip+"\";";
		String result="";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
			result = "PASS";
		} catch (SQLException e) {
			result = "FAIL";
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public void insertCard(Card card, String ip){
		String query ="insert into nedatabase.cardinfo values (\""+ip+"\",\""+card.getId()+"\",\""+card.getCardName()+"\",\""+card.getPrimaryState()+"\",\""+card.getProvisionPec()+"\",\""+
			     card.getMod()+"\",\""+card.getProfile()+"\",\""+card.getTraficStatus()+"\",\""+card.getSerialNo()+"\")";

		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String insertCardHtml(Card card, String ip){
		String query ="insert into nedatabase.cardinfo values (\""+ip+"\",\""+card.getId()+"\",\""+card.getCardName()+"\",\""+card.getPrimaryState()+"\",\""+card.getProvisionPec()+"\",\""+
			     card.getMod()+"\",\""+card.getProfile()+"\",\""+card.getTraficStatus()+"\",\""+card.getSerialNo()+"\")";

		String result;
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
			result = "PASS::"+card.getId()+"::"+card.getSerialNo();
		} catch (SQLException e) {
			result = "FAIL::"+card.getId()+"::"+card.getSerialNo();
			e.printStackTrace();
		}
		return result;
	}
	
	public void updateCard(Card card, String ip){
		String updateQuery ="UPDATE nedatabase.cardinfo SET primarystate=\""+card.getPrimaryState()+"\",provisionpecs=\""+card.getProvisionPec()+"\",mode=\""+card.getMod()+"\",profile=\""+card.getProfile()+"\",traficstatus=\""+card.getTraficStatus()+"\" WHERE IP=\""+card.getIp()+"\" AND CARDID=\""+card.getId()+"\";";
		System.out.println(updateQuery);
		try {
			Statement st = con.createStatement();
			st.executeUpdate(updateQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String updateCardhtml(Card card, String ip){
		String updateQuery ="UPDATE nedatabase.cardinfo SET primarystate=\""+card.getPrimaryState()+"\",provisionpecs=\""+card.getProvisionPec()+"\",mode=\""+card.getMod()+"\",profile=\""+card.getProfile()+"\",traficstatus=\""+card.getTraficStatus()+"\" WHERE IP=\""+card.getIp()+"\" AND CARDID=\""+card.getId()+"\";";
		System.out.println(updateQuery);
		String result = "";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(updateQuery);
			result = "PASS::"+card.getId()+"::"+card.getSerialNo();
		} catch (SQLException e) {
			e.printStackTrace();
			result = "FAIL::"+card.getId()+"::"+card.getSerialNo();
		}
		return result;
	}
	
	public void insertNeDetails(String ip, String port,String shelf,NeInfo neinfo){
		String query ="insert into nedatabase.neinfo values (\""+ip+"\",\""+port+"\",\""+shelf+"\",\""+neinfo.getLocation()+"\",\""+neinfo.getSyncStatus()+"\",\""+
	     neinfo.getSoftwareVersion()+"\",\""+neinfo.getAreaServerd()+"\",\""+neinfo.getStatus()+"\",\""+neinfo.getNeName()+"\")";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public void insertAlarm(com.org.simulation.ne.domain.Alarm alarm){
		String query ="insert into nedatabase.alarms values (\""+alarm.getIp()+"\","+alarm.getAlarmid()+",\""+alarm.getNename()+"\",\""+alarm.getUnit()+"\",\""+alarm.getSeviourity()+"\",\""+
				alarm.getTime()+"\",\""+alarm.getDiscription()+"\",\""+alarm.getLocation()+"\",\""+alarm.getDocumentid()+"\",CURDATE())";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public void clearAllTable(){
		String[] queries = {"delete from nedatabase.alarms;","delete from nedatabase.facility;","delete from nedatabase.ipshelf;","delete from nedatabase.cardinfo;","delete from nedatabase.neinfo;"};
		try {
			Statement st = con.createStatement();
			for(String query : queries){
				st.executeUpdate(query);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clearAlarmTable(){
		String[] queries = {"delete from nedatabase.alarms;"};
		try {
			Statement st = con.createStatement();
			for(String query : queries){
				st.executeUpdate(query);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getMaxAlarmId(){
		String query = "SELECT MAX(alarmid) FROM nedatabase.alarms;";
		int value=0;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
			    value = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public Map<String, String> getAllNe(){
		 Map<String, String> allNeAndPort = new HashMap<String, String>();
		 
		 String query = "select * from nedatabase.neinfo";
		  try {
				Statement st  = con.createStatement();
				ResultSet rst =  st.executeQuery(query);
				while(rst.next()){
					allNeAndPort.put(rst.getString(1), rst.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return allNeAndPort;
	}
	
	public void disposeConnection(){
		try {
			con.close();
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
}
