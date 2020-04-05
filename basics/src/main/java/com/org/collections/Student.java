package com.org.collections;

import com.org.domain.collection.Person;

public class Student implements Comparable<Student>{

	int id;
    String name;
	
    Student(int id , String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj==null){
			throw new IllegalArgumentException("Not a legal Value");
		}
		if(obj instanceof Person){
			if(this.id == ((Person)obj).id){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		int result =1 ; 
		int prime = 31;
		
		result = result * prime + this.id;
		
		result = result * prime + this.name.hashCode();
		
		return result;
	}
 
	@Override
	public int compareTo(Student per){
		
		if(per ==null){
			throw new IllegalArgumentException("Not a valid value");
		}
		if(this.equals(per)){
			return 0;
		}else if(this.id > per.id){
			return 1;
		}else{
			return -1;
		}
		
	}
	

}
