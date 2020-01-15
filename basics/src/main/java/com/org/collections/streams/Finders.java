package com.org.collections.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.org.domain.first.Trade;
import com.org.domainhandlerUtil.TradeUtil;

public class Finders {

	public static void main(String[] args) {
		List<Trade> tradeList = TradeUtil.createTrades();
		 
		Map<String, List<Trade>> map = tradeList.stream().collect(Collectors.groupingBy(e-> e.getStatus()));
	    
		
		map.entrySet().stream().forEach(e-> System.out.println(e.getKey()+"  "+e.getValue()));
	}
}
