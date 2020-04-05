package com.org.collections;

import com.org.domain.collection.Person;

import java.util.Spliterator;
import java.util.function.Consumer;

public class PersonSpliterator implements Spliterator<Person>{
	
	Spliterator<String> lineSpliterator;
	private String name;
	private int age;
	private String location;
	
	public PersonSpliterator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator = lineSpliterator;
	}
	
	@Override
	public boolean tryAdvance(Consumer<? super Person> action) {
		if(this.lineSpliterator.tryAdvance(line-> this.name = line)
				&& this.lineSpliterator.tryAdvance(line-> this.age = Integer.parseInt(line)) 
				&& this.lineSpliterator.tryAdvance(line-> this.location = line)) {

			Person p1 = new Person(this.name, this.age,this.location);
			
			action.accept(p1);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Spliterator<Person> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		return lineSpliterator.estimateSize()/3;
	}

	@Override
	public int characteristics() {
		return lineSpliterator.characteristics();
	}

}
