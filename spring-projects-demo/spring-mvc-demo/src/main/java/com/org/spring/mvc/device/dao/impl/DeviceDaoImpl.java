package com.org.spring.mvc.device.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.org.spring.mvc.controller.domain.Device;
import com.org.spring.mvc.device.dao.DeviceDao;

@Repository
public class DeviceDaoImpl implements DeviceDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addDevice(Device d) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(d);
    }

    @Override
    public void updateDevice(Device d) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(d);
    }

    @Override
    public List<Device> listDevices() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Device> deviceList = session.createQuery("from Device").list();
        for (Device d : deviceList) {
            //System.out.println("Person List::"+d);
        }
        return deviceList;
    }

    @Override
    public Device getDeviceByIp(String ip) {
        Session session = this.sessionFactory.getCurrentSession();
        Device d = (Device) session.load(Device.class, new String(ip));
        //System.out.println("Person loaded successfully, Person details="+d);
        return d;
    }

    @Override
    public void removeDevice(String ip) {
        Session session = this.sessionFactory.getCurrentSession();
        Device d = (Device) session.load(Device.class, new String(ip));
        if (null != d) {
            session.delete(d);
        }
    }

}
