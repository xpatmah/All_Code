package com.org.soap.service.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.org.soap.service.endpoints.CustomerOrdersImpl;
import com.org.soap.service.endpoints.SoapServiceEndPoints;

@Configuration
public class WebConfigClass {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint getPoint() {
        Endpoint endPointImpl = new EndpointImpl(bus, new SoapServiceEndPoints());
        endPointImpl.publish("/soapws");
        return endPointImpl;
    }

    @Bean
    public Endpoint getCustomerOrder() {
        Endpoint endPointImpl = new EndpointImpl(bus, new CustomerOrdersImpl());
        endPointImpl.publish("/customerorderservice");
        return endPointImpl;
    }


}
