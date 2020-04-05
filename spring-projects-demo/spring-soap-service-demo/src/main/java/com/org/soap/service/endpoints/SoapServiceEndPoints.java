package com.org.soap.service.endpoints;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;

@WebService
@Features(features = "org.apache.cxf.feature.LoggingFeature")
public class SoapServiceEndPoints {

    @WebMethod
    public String getHello() {

        return "Hello apache CXF";
    }

    @WebMethod
    public Integer getToalSum(int a, int b) {
        return a + b;
    }


}
