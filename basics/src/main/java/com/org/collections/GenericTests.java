package com.org.collections;

import com.org.domain.collection.Honda;
import com.org.domain.collection.MoterCycle;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class GenericTests {

	public static double sum(Collection<? extends Number> number){
		
		double sum = 0.0;
		for (Number num : number){
			sum = sum + num.doubleValue();
		}
		return sum;
		
	}
	
	
	public static double Aum(Collection<? extends Number> number){
		
		double sum = 0.0;
		for (Number num : number){
			sum = sum + num.doubleValue();
		}
		return sum;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Arrays.asList(1,1);
		
		List<Object> intList = Arrays.asList(1,1,"1");
		
		List<Object> objInterger = Arrays.asList("1",1);
		 
		 Collection<? super Object> ob2 = objInterger;    // need to check how it gets processed
		 
		 List<Integer> obj = Arrays.asList(1,1);
		 
		 obj.toArray();
		 
		 Object one= "sfs";
		 
		 Object two = "sdfsdf";
		 
		 
		 
		 List<? extends Integer> objList2 = obj; // the Type parameter of this list will be unique 
		 
		 
		 
		 List<? extends Object> objectsdd = obj;
		 
		 List intlist = objList2;
		 
		 List<? super Integer> objList = intlist;
		
		
	   List obj2 = objList;
	   
	    Object er3 = obj.get(2); 
	   
	    obj2.add(er3);
	    
	 //   List<? super Number> objList2 = obj;
		// always remember capture#3 
	    
	    
	  //  Aum(objList);
	    
	  //  sum(objList);
	    
	    Aum(obj);
	    
		
		
		
		List<List<?>> arrayList = new ArrayList<List<?>>();
		Lists.toList(); // potential heap pollution   
		
        Class<?> subclass = MoterCycle.class;
	                   
		Stack stack = new Stack();
		
		Stack<String> stack2 = new Stack<String>();
		stack = stack2; //No Warning while assigning the parameterize type of row type
		
		Class<Integer> intClass = Integer.class;
	
		
		Class<? extends Number> in = intClass;
		
		Number n = new Integer(23);
		
		
		if(n.getClass()==in){
			System.out.println("Equal");
		}
		
		List<Integer> intlistt = new ArrayList<Integer>();
		
		List<?> allList = intlistt;
		
		Stack<Object> intStack = new Stack<>();
		
		Stack<? super Number> numStack = intStack;

		
		stack.toArray();
		
		Stack<String> stack3 = new Stack<String>();
		
		List<Integer> intt = new ArrayList<Integer>();
		intt.add(4);
		intt.add(6);
		intt.add(7);
		intt.add(8);
		
		stack3=stack;
		
		Method[] metho = subclass.getDeclaredMethods();
		for(Method me  : metho){
			System.out.println(me.toString());
			List<?> listu=Arrays.asList();
			Class<Integer> intclass =Integer.class; 
		}
		
	}
	
	public MoterCycle getMoterCycle(){
		return new Honda(767, 87686);
	}
	
	/*	public  <T> List<T> reverseList( List<T> inputList){
		
		List<T> arrayList = new ArrayList<T>();
		
		for(int i=arrayList.size()-1;i>=0;i--){
			arrayList.add(inputList.get(arrayList.size()-i-1));
		}
		
		return arrayList;
		
	}*/
	
        public  <T> List<T> newreverseList( List<T> inputList){
		
		List<T> arrayList = new ArrayList<T>();
		
		for(int i=arrayList.size()-1;i>=0;i--){
			arrayList.add(inputList.get(arrayList.size()-i-1));
		}
		
		return arrayList;
		
	}
	

	public  <T>  List<?>  reverseList( List<?> inputList){
		   return newreverseList(inputList);
	}


}
