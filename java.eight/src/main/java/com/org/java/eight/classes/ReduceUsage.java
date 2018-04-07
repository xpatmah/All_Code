package com.org.java.eight.classes;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.org.java.domain.Trade;
import com.org.util.TradeUtil;

public class ReduceUsage {
   
	public static void main(String[] args) {
		
		// Slicing of Data 
		List<Trade> traders = TradeUtil.createTrades();
		//traders.stream().filter((trade) -> trade.getQuantity()> 100).map((trade) -> trade.getQuantity()).reduce(Integer::sum);
		
		Stream<String> stringStream = traders.stream().map((trade)-> trade.getStatus());
		 
	//	stringStream.forEach(System.out::println);
		
		Set<String> trade = traders.stream().map((tradess)-> tradess.getStatus()).collect(Collectors.toSet());
		
		trade.forEach(System.out::println);
		
	}
	
}
