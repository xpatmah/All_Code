package com.org.spring.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.spring.mvc.controller.domain.Device;
import com.org.spring.mvc.device.dao.DeviceDao;
import com.org.spring.mvc.service.DeviceService;

@Service(value="deviceService")
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceDao deviceDao;

	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}

	
	@Override
	@Transactional
	public void addDevice(Device d) {
		this.deviceDao.addDevice(d);
	}

	@Override
	@Transactional
	public void updateDevice(Device d) {
		this.deviceDao.updateDevice(d);
	}

	@Override
	@Transactional
	public List<Device> listDevices() {
		return this.deviceDao.listDevices();
	}

	@Override
	@Transactional
	public Device getDeviceByIp(String id) {
		return this.deviceDao.getDeviceByIp(id);
	}

	@Override
	@Transactional
	public void removeDevice(String id) {
		this.deviceDao.removeDevice(id);
	}

}
