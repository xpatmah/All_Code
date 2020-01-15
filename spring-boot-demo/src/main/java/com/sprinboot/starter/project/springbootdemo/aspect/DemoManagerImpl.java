package com.sprinboot.starter.project.springbootdemo.aspect;
public class DemoManagerImpl implements DemoManager
{
    @Override
    public String getServiceName()
    {
        return "My first service with Spring 3";
    }
}