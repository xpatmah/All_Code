package com.org.problemsolving.dp.first;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaCheck {

	private final AtomicInteger ctl = new AtomicInteger(ctlOf(-1 << 29, 0));
	
	 private static final int COUNT_BITS = Integer.SIZE - 3;
	 private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
	
	public static void main(String[] args) {
		
      JavaCheck cp = new JavaCheck();
      cp.classMethod();
	
	}
   
    public void classMethod(){
    	
    	 System.out.println(ctl.get());
    	
    	  System.out.println(Integer.toBinaryString(-1));
    	    
    	  ConcurrentHashMap<String, String> a1 = new ConcurrentHashMap<>();
    	  a1.put("gkg", "fddd");
    	  System.out.println(Integer.toBinaryString(536870911));
    	  
    	  System.out.println(Integer.toBinaryString(-1 << 29));
    }

    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }
    
}



