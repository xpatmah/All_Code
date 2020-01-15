package com.java.webnms.response;

import java.io.Serializable;

public class NE implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7612361724088163193L;
	
	private String ip;
	
	private String port;
	
	private String shelf;
	
    private String syncstatus;
    
    public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public String getSyncstatus() {
		return syncstatus;
	}

	public void setSyncstatus(String syncstatus) {
		this.syncstatus = syncstatus;
	}

	public String getSoftwareversion() {
		return softwareversion;
	}

	public void setSoftwareversion(String softwareversion) {
		this.softwareversion = softwareversion;
	}

	public String getAreaServed() {
		return areaServed;
	}

	public void setAreaServed(String areaServed) {
		this.areaServed = areaServed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	private String softwareversion;
    
    private String areaServed;
    
    private String status;
    
    private String name;
    
	private String location;
	
}
