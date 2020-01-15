package com.org.collections;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class CreatingSpliterator {

	public static void main(String[] args)  {
		Path path = Paths.get("src/javastreams/people.txt");
		System.out.println(path.toUri());
		try(Stream<String> lines = Files.lines(path)){
			
			Spliterator<String> splits = lines.spliterator();
			
			Spliterator<Person> personSplitor = new PersonSpliterator(splits);
			
			Stream<Person> people = StreamSupport.stream(personSplitor, false);
			people.forEach(System.out::println);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
