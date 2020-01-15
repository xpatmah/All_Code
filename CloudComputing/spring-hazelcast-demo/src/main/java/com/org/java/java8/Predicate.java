package com.org.java.java8;

@FunctionalInterface
public interface Predicate<T> {
		
	boolean test(T e);
	
	default Predicate<T> add(Predicate<T> other) {
		return t -> test(t) && other.test(t);
	}
	
	default Predicate<T> or(Predicate<T> other){
		return t -> test(t) || other.test(t);
	}
	
	public static <U> Predicate<U> isEqualTo(U s){
		return t -> t.equals(s);
	}
	
	
}
