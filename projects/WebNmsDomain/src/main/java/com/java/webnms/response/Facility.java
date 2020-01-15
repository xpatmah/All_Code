package com.java.webnms.response;

import java.io.Serializable;

public class Facility implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2202759649374084709L;

	private String facility;
	
	private String serviceType;
	
	private String frequency;

	private String wavelength;
	
	private String diffrentialEncoding;
	
	private String cdfi;
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getWavelength() {
		return wavelength;
	}

	public void setWavelength(String wavelength) {
		this.wavelength = wavelength;
	}

	public String getDiffrentialEncoding() {
		return diffrentialEncoding;
	}

	public void setDiffrentialEncoding(String diffrentialEncoding) {
		this.diffrentialEncoding = diffrentialEncoding;
	}

	public String getCdfi() {
		return cdfi;
	}

	public void setCdfi(String cdfi) {
		this.cdfi = cdfi;
	}

	
}
