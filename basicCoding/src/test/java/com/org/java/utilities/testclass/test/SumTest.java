package com.org.java.utilities.testclass.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.org.java.utilities.testclass.Sum;

public class SumTest {

	Sum sum;
	
	@Before
	public void assignVariable(){
		sum = new Sum();
		System.out.println("Running for the first time");
	}
	
	@Ignore(value="welwmewr")
	@Test
	public void sumofTwo(){
		System.out.println("Running ");
		assertEquals(sum.getSum(23, 23),46);
	}
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass()");
	}
	
	@AfterClass
    public static void afterClass(){
		System.out.println("afterClass()");
	}
	
	@Test
	public void testSum() {
		System.out.println("Running ");
		assertEquals(sum.getSum(23, 23),46);
		
		//fail("Not yet implemented");
	}

	@After
	public void after(){
		System.out.println("After");
	}
	
	@Test
	public void arraySort(){
		int[] numbers = {3,1,7,4,90,2};
		Arrays.sort(numbers);
		assertArrayEquals(numbers, new int[]{1,2,3,4,7,90});
		
	}
	
	@Test(expected=NullPointerException.class)
	public void arraySortException(){
	//	int[] numbers = {};  will fail if you use empty array
		int[] numbers = null; 
		Arrays.sort(numbers);
		
	}
	
	
	@Test(timeout=50)
	public void arraySorttimePerformace(){
		for(int i=0;i<1000000;i++){
              int[] numbers = {i+1,i,i-1};
              Arrays.sort(numbers);
		}
	}
	
}
