package com.org.spring.mvc.device.dao;

import java.util.List;

import com.org.spring.mvc.controller.domain.Device;

public interface DeviceDao {


	public void addDevice(Device p);
	public void updateDevice(Device p);
	public List<Device> listDevices();
	public Device getDeviceByIp(String id);
	public void removeDevice(String id);
	
}
