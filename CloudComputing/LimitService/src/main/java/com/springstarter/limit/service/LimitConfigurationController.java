package com.springstarter.limit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springstarter.limit.service.bean.LimitConfiguration;

@RestController
public class LimitConfigurationController {

	@Autowired
	private Configuration configuration;
	
	
	@GetMapping("/limits")
	public LimitConfiguration reterieveLimitConfiguration() { 		
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
	
}
