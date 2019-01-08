package com.spring.java.currency.service;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchnageValue retrieveExchnageValue(@PathVariable String from, @PathVariable String to) {
		return new ExchnageValue(1000L, from, to, BigDecimal.valueOf(65));
	}
	
}
