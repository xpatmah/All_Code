package com.org.spring.mvc.service;

import java.util.List;

import com.org.spring.mvc.controller.domain.Device;

public interface DeviceService {

	public void addDevice(Device p);
	public void updateDevice(Device p);
	public List<Device> listDevices();
	public Device getDeviceByIp(String ip);
	public void removeDevice(String id);
	
}