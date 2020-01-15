package com.org.simulation.ne.domain;

import java.util.HashMap;
import java.util.Map;

public class Card {
	
	private String cardName;
	
	private String ip;
	
	private String id;
	
	private String slot;
	
	private String primaryState;

	private String provisionPec;
	
	private String mod;

	private String profile;
	
	private String traficStatus;
	
	private String serialNo;
	
	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getPrimaryState() {
		return primaryState;
	}

	public void setPrimaryState(String primaryState) {
		this.primaryState = primaryState;
	}

	public String getProvisionPec() {
		return provisionPec;
	}

	public void setProvisionPec(String provisionPec) {
		this.provisionPec = provisionPec;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getTraficStatus() {
		return traficStatus;
	}

	public void setTraficStatus(String traficStatus) {
		this.traficStatus = traficStatus;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	
	
	private Map<String, Facility> portFacilityMap = new HashMap<String, Facility>();

	public Map<String, Facility> getPortFacilityMap() {
		return portFacilityMap;
	}
	
	public Facility getFacilityOnPort(String port){
		return portFacilityMap.get(port);
	}
}
