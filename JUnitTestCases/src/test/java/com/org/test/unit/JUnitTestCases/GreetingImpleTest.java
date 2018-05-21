package com.org.test.unit.JUnitTestCases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class GreetingImpleTest {
	
		@Test
		public void greetings() {
			GreetingImpl imp = new GreetingImpl();
			String name = imp.getName("Ramesh");
			assertNotNull(name);
			assertEquals("hello Ramesh", name);
		}
	
	
	
}
