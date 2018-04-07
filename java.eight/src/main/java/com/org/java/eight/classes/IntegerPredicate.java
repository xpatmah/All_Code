package com.org.java.eight.classes;

import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

import com.org.java.domain.Trade;
import com.org.util.TradeUtil;

public class IntegerPredicate {

	
	public static void main(String[] args) {
		IntPredicate intPradicate = (i) -> i%3==0; 
		IntConsumer suplied = (i)-> System.out.println(i);
		
		List<Trade> tradeList = TradeUtil.createTrades();
		
		List<Trade> filterTradelist = tradeList.stream().filter((trade)-> trade.getQuantity()>10000)
				.filter(Trade::isCancelledTrade).limit(1).collect(Collectors.<Trade>toList());
		
		System.out.println(tradeList.stream().filter((trade)-> trade.getQuantity()> 1000).map((trade) -> trade.getStatus()).count());
		
		
		
		filterTradelist.stream().forEach(System.out::println);
	}
}
