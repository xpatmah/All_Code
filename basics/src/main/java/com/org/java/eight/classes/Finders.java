package com.org.java.eight.classes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.org.eight.domain.Trade;
import com.org.java.util.TradeUtil;

public class Finders {

	public static void main(String[] args) {
		List<Trade> tradeList = TradeUtil.createTrades();
		 
		Map<String, List<Trade>> map = tradeList.stream().collect(Collectors.groupingBy(e-> e.getStatus()));
	    
		
		map.entrySet().stream().forEach(e-> System.out.println(e.getKey()+"  "+e.getValue()));
	}
}
