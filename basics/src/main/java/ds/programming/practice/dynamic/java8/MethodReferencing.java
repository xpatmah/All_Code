package ds.programming.practice.dynamic.java8;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferencing {

	public static void main(String[] args) {
		Stream<String> streams = Stream.of("sfsfs sdfasdfas asfdsaf asfsaf","sdfs sdfsf sdfsdfswer rewtfdsv gfdfsgrg");
		Stream<String> stream3 = Stream.of("sfsfs sdfasdfas asfdsaf asfsaf","sdfs sdfsf sdfsdfswer rewtfdsv gfdfsgrg");
		Stream<String> stream4 = Stream.of("sfsfs sdfasdfas asfdsaf asfsaf","sdfs sdfsf sdfsdfswer rewtfdsv gfdfsgrg");
		Stream<Stream<String>> stream5 = Stream.of(streams,stream3,stream4);
		
		Stream<String> onlyStram = stream5.flatMap(Function.identity()).flatMap(s-> Stream.of(s.split(" ")));
		
		onlyStram.filter(s-> !s.startsWith("s")).collect(Collectors.toList()).forEach(System.out::println);
		
		
		ArrayList<Integer> intlist = new ArrayList<>();
		intlist.add(23);
		intlist.add(33);
		intlist.add(34);
		 
		intlist.add(67);
		intlist.add(90);
		
		Number x = 2;
		
		//x = "fsklfs";
		
		
		intlist.add(1,37);
		
		intlist.forEach(System.out::println);
		
	}
	
}
